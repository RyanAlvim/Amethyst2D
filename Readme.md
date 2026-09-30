# 💜 Amethyst

<p align="center">
  <img src="https://img.shields.io/badge/Java-8%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 8+">
  <img src="https://img.shields.io/badge/2D-Game%20Engine-8A2BE2?style=for-the-badge" alt="2D Game Engine">
  <img src="https://img.shields.io/badge/Status-Experimental-6C757D?style=for-the-badge" alt="Experimental">
</p>

<p align="center">
  <strong>Um framework em Java para desenvolvimento de jogos 2D.</strong>
</p>

<p align="center">
  Amethyst nasceu como um projeto experimental para explorar a construção de uma estrutura própria para desenvolvimento de jogos utilizando Java.
</p>

---

## 🎮 Sobre

**Amethyst** é um projeto desenvolvido em **Java** com foco na criação de jogos e aplicações interativas em **2D**.

O projeto surgiu com o objetivo de compreender, na prática, como funciona a construção de uma estrutura própria para jogos, indo além da utilização de engines prontas.

Durante seu desenvolvimento foram explorados conceitos como:

- Game Loop
- Renderização 2D
- Processamento de eventos
- Entrada do usuário
- Programação Orientada a Objetos
- Gerenciamento de recursos
- Arquitetura de aplicações
- Desenvolvimento de bibliotecas e frameworks

A Amethyst também serviu como laboratório para experimentar diferentes abordagens de desenvolvimento de jogos utilizando o ecossistema Java.

---

# ✨ Principais objetivos

A Amethyst foi criada com alguns objetivos principais:

### 🎯 Aprender

Compreender os principais componentes necessários para construir um framework de jogos 2D.

### 🧩 Abstrair complexidade

Criar uma camada de abstração que permita desenvolver jogos sem precisar lidar diretamente com todos os detalhes de baixo nível.

### ♻️ Reutilização

Fornecer componentes que possam ser reutilizados em diferentes projetos.

### ☕ Explorar Java

Utilizar Java não apenas para aplicações tradicionais, mas também para desenvolvimento de aplicações gráficas e jogos.

---

# 🏗️ Conceito

A ideia central da Amethyst pode ser representada de forma simplificada:

```text
                    ┌─────────────────────┐
                    │       JOGO          │
                    │                     │
                    │  Regras             │
                    │  Objetos            │
                    │  Cenas              │
                    │  Interações         │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │      AMETHYST       │
                    │                     │
                    │  Game Loop          │
                    │  Input              │
                    │  Renderização       │
                    │  Recursos           │
                    │  Eventos            │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │        JAVA         │
                    │                     │
                    │  Runtime / APIs     │
                    └─────────────────────┘
