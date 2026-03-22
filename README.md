# 🚀 SimuladorTrajetórias — Simulador de Lançamento de Projéteis

[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org/)

**Simulador de trajetórias de projéteis com visualização gráfica ASCII no terminal.**

---

## 📋 Descrição

O **SimuladorTrajetórias** é uma aplicação de física que simula o lançamento oblíquo de projéteis, calculando a trajetória completa e desenhando o gráfico em tempo real no terminal usando caracteres ASCII. Desenvolvido como projeto da cadeira de Fundamentos de Física.

## ✨ Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| 📐 **Modo 1 — Variáveis diretas** | Introduz altura inicial, velocidade inicial e ângulo |
| 🎯 **Modo 2 — Tempo e alcance** | Calcula a trajetória a partir do tempo de voo e alcance |
| 📊 **Gráfico ASCII** | Visualização da trajetória com eixos e labels |
| 🔢 **Cálculos automáticos** | Tempo de voo, deslocamento X, altura máxima, ângulo |
| 🔄 **Repetição** | Permite simular múltiplas trajetórias seguidas |
| 📏 **Gráfico configurável** | Altura e largura do gráfico definidos pelo utilizador |

## 🧮 Física

O simulador usa as equações do lançamento oblíquo:

```
x(t) = v₀ · cos(θ) · t
y(t) = y₀ + v₀ · sin(θ) · t - ½g · t²
```

Onde `v₀` é a velocidade inicial, `θ` o ângulo, `y₀` a altura inicial e `g ≈ 10 m/s²`.

## 🎯 Como Usar

1. Executar o `Main.kt`
2. Escolher o modo de simulação (1 ou 2)
3. Introduzir as dimensões do gráfico
4. Introduzir os parâmetros físicos
5. Visualizar a trajetória e os resultados

### Exemplo de Output

```
Trajetória da bola:
┌──────────────────────────────────────┐
│            *  *                       │
│          *      *                     │
│        *          *                   │
│      *              *                 │
│    *                  *               │
│  *                      *             │
│*                          *           │
└──────────────────────────────────────┘

Tempo (s)    X (m)
3.24         45.67
```

## 🛠️ Tecnologias

- **Linguagem:** Kotlin
- **Gráficos:** [java-ascii-render](https://github.com/indvd00m/java-ascii-render) (plots ASCII)
- **Build:** Maven (pom.xml)

## 🚀 Executar

```bash
# Com Maven
mvn compile exec:java
```

## 👤 Autor

**Gonçalo Alegria** — [@goncaloalegria](https://github.com/goncaloalegria)

Projeto académico · Fundamentos de Física · Universidade Lusófona de Lisboa
