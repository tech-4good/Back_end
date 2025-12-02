"""
Consumer Python para mensagens da Fila de Espera do RabbitMQ
Recebe e processa mensagens enviadas pelo producer Java da aplicação Tech4Good
"""

import pika
import json
import sys
from datetime import datetime
from typing import Dict, Any


class FilaEsperaConsumer:
    def __init__(self, 
                 rabbitmq_host: str = 'localhost', 
                 rabbitmq_port: int = 5672,
                 rabbitmq_user: str = 'guest',
                 rabbitmq_password: str = 'guest',
                 queue_name: str = 'tech4good.filaespera.queue'):
        """
        Inicializa o consumer da Fila de Espera
        
        Args:
            rabbitmq_host: Host do RabbitMQ (padrão: localhost)
            rabbitmq_port: Porta do RabbitMQ (padrão: 5672)
            rabbitmq_user: Usuário do RabbitMQ (padrão: guest)
            rabbitmq_password: Senha do RabbitMQ (padrão: guest)
            queue_name: Nome da fila (padrão: tech4good.filaespera.queue)
        """
        self.rabbitmq_host = rabbitmq_host
        self.rabbitmq_port = rabbitmq_port
        self.rabbitmq_user = rabbitmq_user
        self.rabbitmq_password = rabbitmq_password
        self.queue_name = queue_name
        self.connection = None
        self.channel = None
        
    def connect(self):
        """Estabelece conexão com o RabbitMQ"""
        try:
            credentials = pika.PlainCredentials(self.rabbitmq_user, self.rabbitmq_password)
            parameters = pika.ConnectionParameters(
                host=self.rabbitmq_host,
                port=self.rabbitmq_port,
                credentials=credentials
            )
            
            self.connection = pika.BlockingConnection(parameters)
            self.channel = self.connection.channel()
            
            # Garante que a fila existe (caso não tenha sido criada pelo Java)
            self.channel.queue_declare(queue=self.queue_name, durable=True)
            
            print(f"Conectado ao RabbitMQ em {self.rabbitmq_host}:{self.rabbitmq_port}")
            print(f"Aguardando mensagens da fila: {self.queue_name}")
            print("Para sair, pressione CTRL+C")
            print("-" * 60)
            
        except pika.exceptions.AMQPConnectionError as e:
            print(f"Erro de conexão com RabbitMQ: {e}")
            print("Verifique se o RabbitMQ está rodando e as credenciais estão corretas")
            sys.exit(1)
        except Exception as e:
            print(f"Erro inesperado ao conectar: {e}")
            sys.exit(1)

    def process_message(self, ch, method, properties, body):
        """
        Processa uma mensagem recebida da fila
        
        Args:
            ch: Canal do RabbitMQ
            method: Método de entrega da mensagem
            properties: Propriedades da mensagem
            body: Corpo da mensagem (JSON)
        """
        try:
            # Decodifica o JSON da mensagem
            message_str = body.decode('utf-8')
            message_data = json.loads(message_str)
            
            # Extrai informações da mensagem
            fila_espera_id = message_data.get('filaEsperaId')
            beneficiado_id = message_data.get('beneficiadoId')
            beneficiado_nome = message_data.get('beneficiadoNome')
            data_entrada = message_data.get('dataEntradaFila')
            tipo_evento = message_data.get('tipoEvento')
            mensagem = message_data.get('mensagem')
            
            # Formata a saída no terminal
            timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            print(f"\nNOVA MENSAGEM RECEBIDA - {timestamp}")
            print("=" * 50)
            print(f"ID da Fila: {fila_espera_id}")
            print(f"Beneficiado: {beneficiado_nome} (ID: {beneficiado_id})")
            print(f"Data de Entrada: {data_entrada}")
            
            # Emoji baseado no tipo de evento
            print(f"Tipo de Evento: {tipo_evento}")
            print(f"Mensagem: {mensagem}")
            print("=" * 50)
            
            # Acknowledge da mensagem (confirma que foi processada)
            ch.basic_ack(delivery_tag=method.delivery_tag)
            
        except json.JSONDecodeError as e:
            print(f"Erro ao decodificar JSON: {e}")
            print(f"Mensagem raw: {body}")
            # Rejeita a mensagem malformada
            ch.basic_nack(delivery_tag=method.delivery_tag, requeue=False)
            
        except Exception as e:
            print(f"Erro ao processar mensagem: {e}")
            print(f"Mensagem raw: {body}")
            # Rejeita a mensagem com erro
            ch.basic_nack(delivery_tag=method.delivery_tag, requeue=True)

    def start_consuming(self):
        """Inicia o consumo de mensagens"""
        try:
            # Configura QoS para processar uma mensagem por vez
            self.channel.basic_qos(prefetch_count=1)
            
            # Configura o consumer
            self.channel.basic_consume(
                queue=self.queue_name,
                on_message_callback=self.process_message
            )
            
            # Inicia o consumo
            self.channel.start_consuming()
            
        except KeyboardInterrupt:
            print("\nParando o consumer...")
            self.stop_consuming()
            
        except Exception as e:
            print(f"Erro durante o consumo: {e}")
            self.stop_consuming()

    def stop_consuming(self):
        """Para o consumo e fecha a conexão"""
        try:
            if self.channel:
                self.channel.stop_consuming()
                self.channel.close()
            if self.connection:
                self.connection.close()
            print("Consumer parado com sucesso")
        except Exception as e:
            print(f"Erro ao parar consumer: {e}")

    def print_connection_info(self):
        """Imprime informações de conexão"""
        print("\nINFORMAÇÕES DE CONEXÃO")
        print("-" * 30)
        print(f"Host: {self.rabbitmq_host}")
        print(f"Porta: {self.rabbitmq_port}")
        print(f"Usuário: {self.rabbitmq_user}")
        print(f"Fila: {self.queue_name}")
        print("-" * 30)


def main():
    """Função principal"""
    print("Tech4Good - Consumer da Fila de Espera")
    print("=" * 60)
    
    # Configurações para produção na AWS
    # Use localhost se rodar na mesma máquina que o RabbitMQ
    # Use 10.0.0.20 se rodar de outra instância (IP privado da DB1)
    consumer = FilaEsperaConsumer(
        rabbitmq_host='localhost',  # IP privado da DB1 onde RabbitMQ está rodando
        rabbitmq_port=5672,         # Porta padrão do RabbitMQ
        rabbitmq_user='admin',      # Usuário do RabbitMQ (conforme compose-api.yaml)
        rabbitmq_password='admin123',  # Senha do RabbitMQ (conforme compose-api.yaml)
        queue_name='tech4good.filaespera.queue'  # Nome da fila configurada no Java
    )
    
    consumer.print_connection_info()
    consumer.connect()
    consumer.start_consuming()


if __name__ == '__main__':
    main()