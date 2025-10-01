# Paginação no Sistema de Entregas

## Endpoints Disponíveis

### 1. Listar todas as entregas (com paginação)
```
GET /entregas
```

**Parâmetros opcionais:**
- `page`: Número da página (padrão: 0)
- `size`: Tamanho da página (padrão: 10)
- `sortBy`: Campo para ordenação (padrão: dataRetirada)
- `sortDirection`: Direção da ordenação - asc/desc (padrão: desc)

**Exemplos de uso:**
```
GET /entregas?page=0&size=5
GET /entregas?page=1&size=20&sortBy=id&sortDirection=asc
```

### 2. Histórico de entregas de um beneficiado (com paginação)
```
GET /entregas/historico/{idBeneficiado}
```

**Parâmetros:**
- `idBeneficiado`: ID do beneficiado (obrigatório)
- `dataInicio`: Data de início do filtro (opcional)
- `dataFim`: Data de fim do filtro (opcional)
- `page`: Número da página (padrão: 0)
- `size`: Tamanho da página (padrão: 10)
- `sortBy`: Campo para ordenação (padrão: dataRetirada)
- `sortDirection`: Direção da ordenação - asc/desc (padrão: desc)

**Exemplos de uso:**
```
GET /entregas/historico/123?page=0&size=10
GET /entregas/historico/123?dataInicio=2024-01-01&dataFim=2024-12-31&page=0&size=15
```

## Resposta da API

Ambos os endpoints retornam um objeto JSON com as seguintes informações:

```json
{
  "content": [
    {
      "id": 1,
      "beneficiado": {...},
      "dataRetirada": "2024-10-01",
      // outros campos da entrega
    }
  ],
  "currentPage": 0,
  "totalPages": 5,
  "totalElements": 47,
  "size": 10,
  "hasNext": true,
  "hasPrevious": false
}
```

**Campos da resposta:**
- `content`: Array com os dados da página atual
- `currentPage`: Página atual (inicia em 0)
- `totalPages`: Total de páginas disponíveis
- `totalElements`: Total de elementos encontrados
- `size`: Tamanho da página
- `hasNext`: Se existe próxima página
- `hasPrevious`: Se existe página anterior

## Migração da API Antiga

**⚠️ BREAKING CHANGES:**
- O endpoint `GET /entregas` agora retorna dados paginados por padrão
- O endpoint `GET /entregas/historico/{idBeneficiado}` agora retorna dados paginados por padrão
- Não existem mais endpoints separados para versões paginadas

**Para manter compatibilidade:**
- Se você não passar parâmetros de paginação, receberá a primeira página com 10 itens
- Para obter todos os dados de uma vez, use um `size` grande (ex: `size=1000`)

## Como implementar no frontend

### JavaScript/React exemplo:
```javascript
const [entregas, setEntregas] = useState([]);
const [pagination, setPagination] = useState({
  currentPage: 0,
  totalPages: 0,
  totalElements: 0,
  hasNext: false,
  hasPrevious: false
});

const buscarEntregas = async (page = 0, size = 10) => {
  try {
    const response = await fetch(`/api/entregas?page=${page}&size=${size}`);
    const data = await response.json();
    
    setEntregas(data.content);
    setPagination({
      currentPage: data.currentPage,
      totalPages: data.totalPages,
      totalElements: data.totalElements,
      hasNext: data.hasNext,
      hasPrevious: data.hasPrevious
    });
  } catch (error) {
    console.error('Erro ao buscar entregas:', error);
  }
};

// Componente de paginação
const PaginationComponent = () => {
  const renderPageNumbers = () => {
    const pages = [];
    for (let i = 0; i < pagination.totalPages; i++) {
      pages.push(
        <button
          key={i}
          className={i === pagination.currentPage ? 'active' : ''}
          onClick={() => buscarEntregas(i)}
        >
          {i + 1}
        </button>
      );
    }
    return pages;
  };

  return (
    <div className="pagination">
      <button 
        disabled={!pagination.hasPrevious}
        onClick={() => buscarEntregas(pagination.currentPage - 1)}
      >
        Anterior
      </button>
      
      {renderPageNumbers()}
      
      <button 
        disabled={!pagination.hasNext}
        onClick={() => buscarEntregas(pagination.currentPage + 1)}
      >
        Próximo
      </button>
    </div>
  );
};
```

## Campos disponíveis para ordenação

- `id`: ID da entrega
- `dataRetirada`: Data da retirada
- `beneficiado.nome`: Nome do beneficiado
- `voluntario.nome`: Nome do voluntário

## Configurações recomendadas

- **Tamanho da página**: Entre 10-50 registros por página
- **Ordenação padrão**: Por data de retirada (mais recentes primeiro)
- **Cache**: Considere implementar cache no frontend para melhor performance
