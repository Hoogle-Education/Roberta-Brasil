# Arrays

Motivação: Guardar/criar/acessar um grande número de dados de forma lógica e simples.

## Instanciando um Array

```
  tipo[] nome = new tipo[numero_de_elementos];
```

```java
  int[] listaInteiros = new int[10];
```

## Acessando elementos do vetor

**Cuidado!** As posições do vetor são sempre acessadas de `zero` até `tamanho - 1`.

Modificando o elemento da terceira posição:

```java
  listaInteiros[2] = 4;
```

## Desvantagens de um vetor

1. A princípio ele tem um tamanho fixo.
2. Dificuldade em deletar um elemento.

# ArrayList

São vetores dinâmicos. Baseados em elementos que são compostos por valor e o direcionamento de próximos elementos dessa sequência, de modo bem similar a `LinkedList()`

## .add()