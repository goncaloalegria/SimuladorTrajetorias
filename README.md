# 🚢 boatRadar — Sistema de Monitorização de Barcos

[![C](https://img.shields.io/badge/C-85.3%25-A8B9CC?style=flat-square&logo=c&logoColor=white)](https://en.cppreference.com/)
[![CMake](https://img.shields.io/badge/CMake-14.7%25-064F8C?style=flat-square&logo=cmake&logoColor=white)](https://cmake.org/)

**Sistema de radar para monitorização e rastreamento de barcos numa grelha 20×80.**

---

## 📋 Descrição

O **boatRadar** é um programa em C que simula um radar marítimo. Lê posições de barcos (A–E) a partir de ficheiros de texto representando dois momentos diferentes ("antes" e "depois") e permite consultar coordenadas, visualizar a grelha e detetar movimentos.

## ✨ Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| 📡 **Visualização da grelha** | Imprime a tabela 20×80 com posição dos barcos |
| 🔍 **Consulta de coordenadas** | Localiza um barco específico (A–E) na grelha |
| 🧭 **Deteção de movimentos** | Compara posições entre "antes" e "depois" |
| 📁 **Leitura de ficheiros** | Carrega dados de `tabela_antes.txt` e `tabela_depois.txt` |
| ↕️ **Direção do movimento** | Identifica: cima, baixo, esquerda, direita ou parado |

## 🎯 Como Usar

1. Criar os ficheiros `tabela_antes.txt` e `tabela_depois.txt` (grelhas 20×80 com barcos A–E)
2. Compilar e executar
3. Usar o menu interativo:

```
Menu:
1 - Imprimir tabela "antes"
2 - Imprimir tabela "depois"
3 - Consultar as coordenadas de um barco
4 - Listar barcos que se moveram
5 - Sair
```

### Exemplo

```
Escolha o barco que quer encontrar: B
O barco B encontra-se na linha 12 e na coluna 45

Escolha qual o barco que quer listar o movimento: B
Movimento: O barco moveu-se para a direita.
```

## 🏗️ Arquitetura

```
boatRadar/
├── main.c              # Código fonte principal
├── CMakeLists.txt      # Configuração de build
├── tabela_antes.txt    # Grelha com posições iniciais
└── tabela_depois.txt   # Grelha com posições finais
```

O programa usa `struct barco` com `id`, `linha` e `coluna` para representar cada embarcação, e compara as duas grelhas para calcular a direção do deslocamento.

## 🛠️ Tecnologias

- **Linguagem:** C
- **Build:** CMake
- **I/O:** Leitura de ficheiros com `fgetc`

## 🚀 Compilar e Executar

```bash
# Com CMake
mkdir build && cd build
cmake ..
make
./boatRadar

# Ou diretamente com gcc
gcc main.c -o boatRadar
./boatRadar
```

## 👤 Autor

**Gonçalo Alegria** — [@goncaloalegria](https://github.com/goncaloalegria)

Projeto académico · Universidade Lusófona de Lisboa
