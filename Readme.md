# 💜 Amethyst2D

<p align="center">
  <img src="https://img.shields.io/badge/Java-8%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 8+">
  <img src="https://img.shields.io/badge/Java%20AWT%2FSwing-2D-purple?style=for-the-badge" alt="Java AWT/Swing">
  <img src="https://img.shields.io/badge/Game%20Framework-2D-822A63?style=for-the-badge" alt="2D Game Framework">
  <img src="https://img.shields.io/badge/Status-Experimental-gray?style=for-the-badge" alt="Experimental">
</p>

<p align="center">
  <strong>Biblioteca Java para criação de jogos 2D.</strong>
</p>

<p align="center">
  O Amethyst2D fornece uma estrutura simples para janelas, renderização,
  sprites, animações, teclado, movimentação e colisões.
</p>

---

## 🎮 Sobre

**Amethyst2D** é uma biblioteca desenvolvida em **Java** para facilitar a criação de jogos 2D.

O projeto foi desenvolvido como uma experiência prática na construção de uma estrutura própria para jogos, utilizando principalmente as APIs gráficas do Java, como:

- `java.awt`
- `javax.swing`
- `Graphics2D`
- `BufferStrategy`
- `KeyListener`
- `Image`
- `ImageIcon`

A biblioteca fornece componentes para criar uma aplicação gráfica e trabalhar com objetos 2D, sprites, animações, entrada de teclado e colisões.

Além da biblioteca, o repositório possui um jogo de exemplo chamado **MyGame**, utilizado para demonstrar como os componentes da Amethyst2D podem ser utilizados em uma aplicação real.

---

# ✨ Funcionalidades

A biblioteca atualmente possui componentes para:

- 🪟 Criação e gerenciamento de janelas
- 🎨 Renderização de imagens
- 🖼️ Sprites
- 🎞️ Animações baseadas em spritesheets
- ⌨️ Controle de teclado
- 🎯 Sistema de ações para teclas
- 💥 Detecção de colisões
- 🔄 Rotação de imagens e sprites
- 🚶 Movimentação horizontal e vertical
- 🎯 Movimentação em direção a uma posição
- 📝 Renderização de textos
- 💬 Mensagens através de `JOptionPane`
- 🔁 Controle básico do loop de renderização

---

# 🏗️ Arquitetura

A biblioteca é organizada em quatro principais pacotes:

    Biblioteca/src/
    │
    ├── AmethystCenario/
    │   ├── Object.java
    │   ├── Imagem.java
    │   └── Colisao.java
    │
    ├── AmethystKeyBoard/
    │   ├── Action.java
    │   └── Teclado.java
    │
    ├── AmethystSprites/
    │   ├── Animacao.java
    │   └── Sprite.java
    │
    └── AmethystWindow/
        └── Janela.java

A arquitetura possui uma hierarquia simples entre os objetos gráficos:

    Object
       │
       └── Imagem
             │
             └── Animacao
                   │
                   └── Sprite

Isso permite que funcionalidades sejam acumuladas conforme a classe é especializada.

---

# 🧩 Hierarquia dos objetos

## `Object`

A classe `AmethystCenario.Object` é a classe base dos objetos da biblioteca.

Ela armazena:

- posição X;
- posição Y;
- largura;
- altura;
- rotação.

Também fornece o método:

    colisao(Object obj)

que utiliza o sistema de colisão da biblioteca.

Estrutura conceitual:

    Object
    ├── x
    ├── y
    ├── width
    ├── height
    └── rotacao

---

# 🖼️ Imagem

A classe:

    AmethystCenario.Imagem

estende `Object` e adiciona uma imagem ao objeto.

A imagem é carregada utilizando:

    ImageIcon

Ao carregar uma imagem, sua largura e altura são obtidas automaticamente.

A classe também fornece:

    mostrar()

Esse método utiliza o `Graphics2D` da janela atual para desenhar a imagem.

---

# 💥 Sistema de colisão

A classe:

    AmethystCenario.Colisao

implementa uma detecção de colisão baseada em **retângulos delimitadores**.

O método principal recebe os limites de dois objetos:

    min1
    max1
    min2
    max2

e verifica se existe sobreposição nos eixos X e Y.

Conceitualmente:

    Objeto A
    ┌──────────────┐
    │              │
    │      A       │
    │              │
    └──────────────┘

             ↕ colisão

          ┌──────────────┐
          │              │
          │      B       │
          │              │
          └──────────────┘

O método também possui uma versão que recebe diretamente dois objetos da Amethyst2D:

    Colisao.collided(obj1, obj2)

Por isso qualquer objeto derivado de `Object` pode utilizar:

    objeto.colisao(outroObjeto)

---

# 🎞️ Sistema de animação

A classe:

    AmethystSprites.Animacao

estende `Imagem`.

Ela adiciona suporte a imagens contendo múltiplos frames.

Por exemplo, uma spritesheet pode ser organizada horizontalmente:

    ┌─────┬─────┬─────┬─────┐
    │  1  │  2  │  3  │  4  │
    └─────┴─────┴─────┴─────┘

A biblioteca divide a imagem de acordo com o número de frames informado.

Exemplo conceitual:

    new Animacao("personagem.png", 4);

Nesse caso a largura do sprite é calculada dividindo a largura total da imagem pelo número de frames.

---

## Controle de frames

A classe `Animacao` possui controle sobre:

- frame inicial;
- frame atual;
- frame final;
- quantidade total de frames;
- duração de cada frame;
- loop;
- reprodução;
- pausa;
- parada;
- visibilidade.

Alguns métodos disponíveis são:

    play()
    pause()
    stop()

e:

    setInicioFrame(...)
    setFinalFrame(...)
    setCurrFrame(...)
    setLoop(...)

Também existe configuração de duração individual dos frames:

    setDuracao(frame, tempo)

e configuração de uma duração total:

    setDuracao(tempo)

---

# 🧍 Sprites

A classe:

    AmethystSprites.Sprite

estende `Animacao`.

Ela representa uma extensão voltada para objetos que podem ser movimentados no jogo.

Além das funcionalidades herdadas, possui métodos para movimentação.

### Movimento horizontal

    moverX(esquerda, direita, velocidade)

O método verifica o teclado e movimenta o sprite horizontalmente.

Também existe uma limitação baseada na largura da janela para impedir que o objeto ultrapasse seus limites.

---

### Movimento vertical

    moverY(cima, baixo, velocidade)

Permite movimentar o sprite verticalmente utilizando teclas configuradas.

---

### Movimento em direção a uma posição

A biblioteca também fornece:

    Mover(x, y, velocidade)

Esse método movimenta o sprite em direção a uma posição X/Y determinada.

---

# 🔄 Rotação

Sprites e imagens possuem suporte a rotação.

A classe `Imagem` utiliza:

    AffineTransform

para aplicar transformações durante a renderização.

A classe `Sprite` disponibiliza:

    setRotacao(...)
    getRotacao()

---

# ⚙️ Atributos de Sprite

`Sprite` possui alguns atributos relacionados a movimentação/física:

    massa
    atrito
    rest
    velocidadeY

Eles podem ser acessados através de métodos como:

    setMassa(...)
    getMassa(...)

    setAtrito(...)
    getAtrito(...)

    setRest(...)
    getRest(...)

    setVelocidadeY(...)
    getVelocidadeY(...)

Também existe:

    setAtributos(...)

para configurar esses valores de uma vez.

> **Observação:** esses atributos estão presentes na classe `Sprite`, mas o código atual não implementa um sistema completo de física baseado nesses parâmetros. Eles funcionam como propriedades disponíveis para utilização pelo jogo.

---

# ⌨️ Sistema de teclado

O pacote:

    AmethystKeyBoard

contém o sistema de entrada utilizado pela biblioteca.

A classe principal é:

    Teclado

Ela implementa:

    KeyListener

e mantém uma tabela de teclas registradas.

Algumas teclas já são cadastradas:

    ENTER
    ESC
    ESPACO
    ESQUERDA
    CIMA
    DIREITA
    BAIXO

---

# 🎯 Action

A classe:

    AmethystKeyBoard.Action

representa o estado de uma tecla.

Ela controla:

- quantidade de acionamentos;
- estado da tecla;
- comportamento da ação.

Uma ação pode trabalhar com diferentes comportamentos de pressionamento.

O método:

    isPressed()

permite verificar se a ação está ativa.

Enquanto:

    getAmount()

obtém a quantidade registrada pela ação.

---

# ➕ Adicionando teclas

Novas teclas podem ser registradas através de:

    addTecla(int key)

ou:

    addTecla(int key, int comportamento)

Também é possível remover uma tecla:

    removekey(int key)

E alterar seu comportamento:

    setComportamento(int key, int comportamento)

---

# 🪟 Sistema de janela

A classe:

    AmethystWindow.Janela

é responsável pela janela principal da aplicação.

Ela estende:

    JFrame

Durante sua inicialização, a biblioteca:

1. Obtém o dispositivo gráfico principal;
2. Cria a janela;
3. Configura seu tamanho;
4. Remove a decoração padrão;
5. Torna a janela visível;
6. Cria um `BufferStrategy`;
7. Obtém o objeto `Graphics` utilizado para renderização.

---

# 🖥️ BufferStrategy

A renderização utiliza:

    BufferStrategy

com dois buffers.

A atualização da tela ocorre através do método:

    run()

Esse método:

1. descarta o objeto `Graphics` atual;
2. apresenta o buffer;
3. sincroniza o dispositivo gráfico;
4. obtém um novo objeto `Graphics`.

Conceitualmente:

    Jogo
      │
      ▼
    Desenhar objetos
      │
      ▼
    Graphics
      │
      ▼
    BufferStrategy
      │
      ▼
    Tela

---

# 📝 Texto

A classe `Janela` também permite desenhar texto através de:

    TextMessage(...)

É possível informar:

- texto;
- posição X;
- posição Y;
- cor;
- fonte.

A renderização utiliza antialiasing para o texto.

---

# 💬 Mensagens

A janela fornece:

    message(String mensagem)

que utiliza `JOptionPane` para apresentar uma mensagem ao usuário.

Também existem métodos para fechamento:

    fechar()

e:

    encerrar()

A diferença é que `encerrar()` também chama:

    System.exit(0)

---

# 🔄 Fluxo básico de uma aplicação

O funcionamento básico da biblioteca pode ser representado assim:

    ┌────────────────────┐
    │ Criar Janela       │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │ Carregar recursos  │
    │ e objetos          │
    └─────────┬──────────┘
              │
              ▼
        ┌─────────────┐
        │  Game Loop  │◄───────────────┐
        └──────┬──────┘                │
               │                       │
               ▼                       │
        ┌─────────────┐                │
        │ Processar   │                │
        │ teclado     │                │
        └──────┬──────┘                │
               │                       │
               ▼                       │
        ┌─────────────┐                │
        │ Atualizar   │                │
        │ objetos     │                │
        └──────┬──────┘                │
               │                       │
               ▼                       │
        ┌─────────────┐                │
        │ Renderizar  │                │
        │ objetos     │                │
        └──────┬──────┘                │
               │                       │
               ▼                       │
        ┌─────────────┐                │
        │ Atualizar   │────────────────┘
        │ Buffer      │
        └─────────────┘

O loop em si fica sob responsabilidade do código do jogo, enquanto a Amethyst2D fornece as operações necessárias para entrada e renderização.

---

# 🎮 MyGame

O repositório contém um jogo de exemplo em:

    Jogo/MyGame/

Esse projeto utiliza diretamente a biblioteca Amethyst2D.

A estrutura é:

    MyGame/
    │
    ├── src/
    │   ├── Cenario/
    │   │   └── LoadScene.java
    │   │
    │   ├── Inimigo/
    │   │   └── Inimigo.java
    │   │
    │   ├── Jogador/
    │   │   └── Jogador.java
    │   │
    │   ├── Main/
    │   │   └── Main.java
    │   │
    │   └── Pontos/
    │       └── Moedas.java
    │
    ├── jogador.png
    ├── inimigo.png
    ├── moeda.png
    ├── cena.jpg
    └── cena1.png

---

# 🕹️ Funcionamento do MyGame

O jogo possui uma tela inicial e uma cena principal.

## Tela inicial

A classe:

    Main.Main

cria uma janela de:

    510 x 200

e carrega:

    cena1.png

O teclado é utilizado para controlar a tela inicial.

### ESC

Fecha a janela.

### ENTER

Fecha a tela inicial e inicia:

    LoadScene.run()

---

# 🌎 Cena principal

A classe:

    Cenario.LoadScene

cria uma janela de:

    1000 x 800

e carrega o cenário:

    cena.jpg

Também são criados:

- jogador;
- dois inimigos;
- uma moeda;
- sistema de pontuação.

---

# 🧍 Jogador

A classe:

    Jogador.Jogador

estende:

    Sprite

O jogador utiliza:

    jogador.png

com **20 frames** configurados.

Sua posição inicial é:

    X = 640
    Y = 750

O método:

    seMover()

utiliza as teclas:

    ESQUERDA
    DIREITA

para movimentar o personagem horizontalmente.

---

# 👾 Inimigos

A classe:

    Inimigo.Inimigo

também estende `Sprite`.

O inimigo utiliza:

    inimigo.png

e começa com uma velocidade vertical configurada através de:

    setVelocidadeY(0.4)

Na cena são criados dois inimigos:

    inimigo
    inimigo2

com posições diferentes.

O eixo Y dos inimigos é atualizado continuamente para criar o movimento vertical da cena.

---

# 🪙 Moedas

A classe:

    Pontos.Moedas

estende `Sprite`.

Ela utiliza:

    moeda.png

com 10 frames.

A posição horizontal da moeda é escolhida aleatoriamente a partir de uma lista de posições:

    500
    680
    789
    698
    799
    120
    789
    655

Quando o jogador colide com a moeda:

    pontos++

e a moeda recebe uma nova posição horizontal aleatória.

---

# 💥 Colisão no jogo

O jogo utiliza diretamente o sistema de colisão da Amethyst2D:

    player.colisao(moeda)

e:

    inimigo.colisao(player)

Quando o jogador colide com o inimigo, uma mensagem é exibida:

    Você Morreu! Pontos: X

Depois disso, a janela é encerrada e a tela inicial é criada novamente.

---

# 🔁 Fluxo do jogo

O fluxo do `MyGame` é aproximadamente:

    Main.main()
         │
         ▼
    Main.Game()
         │
         ├── Criar Janela
         ├── Carregar cena inicial
         │
         └── Loop
              │
              ├── Desenhar cena
              ├── Verificar ESC
              └── Verificar ENTER
                       │
                       ▼
                  LoadScene.run()
                       │
                       ├── Criar jogador
                       ├── Criar inimigos
                       ├── Criar moeda
                       │
                       ▼
                    Loop
                       │
                       ├── Desenhar objetos
                       ├── Mover jogador
                       ├── Mover inimigos
                       ├── Atualizar tela
                       ├── Verificar colisão
                       └── Atualizar pontuação

---

# 📁 Estrutura completa

    Amethyst2D/
    │
    ├── Amethyst.jar
    │
    ├── Biblioteca/
    │   ├── src/
    │   │   ├── AmethystCenario/
    │   │   │   ├── Object.java
    │   │   │   ├── Imagem.java
    │   │   │   └── Colisao.java
    │   │   │
    │   │   ├── AmethystKeyBoard/
    │   │   │   ├── Action.java
    │   │   │   └── Teclado.java
    │   │   │
    │   │   ├── AmethystSprites/
    │   │   │   ├── Animacao.java
    │   │   │   └── Sprite.java
    │   │   │
    │   │   └── AmethystWindow/
    │   │       └── Janela.java
    │   │
    │   └── bin/
    │
    ├── Documentacao/
    │   ├── index.html
    │   ├── css/
    │   │   └── style.css
    │   └── img/
    │
    ├── Jogo/
    │   └── MyGame/
    │       ├── src/
    │       │   ├── Cenario/
    │       │   ├── Inimigo/
    │       │   ├── Jogador/
    │       │   ├── Main/
    │       │   └── Pontos/
    │       │
    │       ├── bin/
    │       ├── cena.jpg
    │       ├── cena1.png
    │       ├── inimigo.png
    │       ├── jogador.png
    │       └── moeda.png
    │
    └── Readme.md

---

# 🛠️ Tecnologias

| Tecnologia | Utilização |
|------------|------------|
| Java | Linguagem principal |
| Java AWT | Renderização gráfica |
| Java Swing | Janela e diálogos |
| `Graphics2D` | Desenho dos elementos |
| `BufferStrategy` | Atualização da tela |
| `KeyListener` | Entrada do teclado |
| `ImageIcon` | Carregamento das imagens |
| `AffineTransform` | Rotação dos objetos |
| Eclipse | Ambiente utilizado na estrutura original |

---

# 📚 Conceitos demonstrados

O projeto explora diversos conceitos de programação e desenvolvimento de jogos.

### Java

- Programação Orientada a Objetos
- Herança
- Encapsulamento
- Classes abstratas conceitualmente organizadas por responsabilidade
- Composição
- Manipulação de eventos

### Gráficos

- `Graphics2D`
- `BufferStrategy`
- Transformações gráficas
- Sprites
- Spritesheets
- Renderização de imagens
- Renderização de texto

### Jogos

- Game Loop
- Entrada do jogador
- Movimentação
- Colisão
- Animação
- Pontuação
- Cenas
- Inimigos
- Objetos interativos

---

# 🔬 Decisões técnicas

## Herança para especialização dos objetos

A biblioteca utiliza uma cadeia de herança:

    Object
       ↓
    Imagem
       ↓
    Animacao
       ↓
    Sprite

Isso permite adicionar funcionalidades progressivamente.

Um `Sprite`, por exemplo, possui as funcionalidades de um objeto, de uma imagem e de uma animação, além dos métodos específicos de movimentação.

---

## Singleton da janela

A classe `Janela` mantém uma instância estática:

    Janela.instancia

e fornece:

    Janela.getInstance()

Isso permite que outros componentes, como `Imagem`, `Animacao` e `Sprite`, obtenham acesso à janela e ao objeto `Graphics` atual.

---

## Renderização baseada em spritesheets

A animação utiliza uma imagem contendo vários frames.

A biblioteca calcula a largura de cada frame dividindo a largura da imagem pela quantidade de frames.

Durante a renderização, somente o frame atual é desenhado.

---

# ⚠️ Limitações atuais

O código também possui algumas limitações que fazem parte do estado experimental do projeto.

### Física

Apesar de `Sprite` possuir atributos como:

    massa
    atrito
    restituição
    velocidadeY

não existe atualmente um motor de física completo utilizando esses parâmetros.

### Loop

Os loops do exemplo utilizam:

    for(;;)

sem um mecanismo explícito de controle de FPS.

### Arquitetura

A biblioteca utiliza uma instância global da janela através de `Janela.getInstance()`.

Isso simplifica o desenvolvimento inicial, mas cria um acoplamento entre os objetos gráficos e a janela.

### Animação

A biblioteca possui suporte para controle de frames e duração, porém o jogo de exemplo não utiliza um sistema completo de atualização automática de animações em seu loop.

### Recursos

As imagens são carregadas diretamente através de caminhos fornecidos ao `ImageIcon`, não existindo um gerenciador de recursos centralizado.

---

# 🚧 Estado do projeto

**Experimental / Educacional**

O Amethyst2D foi desenvolvido como uma experiência prática de construção de uma biblioteca própria para jogos 2D.

O projeto não pretende competir com engines completas. Seu principal valor está na implementação e experimentação dos componentes básicos necessários para construir um jogo simples.

---

# 💡 Possíveis evoluções

Algumas evoluções naturais para o projeto seriam:

- [ ] Sistema de FPS / Delta Time
- [ ] Game Loop dedicado
- [ ] Sistema de cenas
- [ ] Gerenciador de recursos
- [ ] Sistema de física
- [ ] Melhor gerenciamento de spritesheets
- [ ] Sistema de câmera
- [ ] Áudio
- [ ] Suporte a mouse
- [ ] Sistema de entidades
- [ ] Melhor separação entre lógica e renderização
- [ ] Redução do acoplamento com `Janela`
- [ ] Sistema de configuração de projeto
- [ ] Build automatizado da biblioteca
- [ ] Documentação da API

---

# 🎓 Objetivo educacional

Mais do que simplesmente criar um jogo, o projeto representa uma experiência de construção de uma **biblioteca reutilizável**.

Ao implementar componentes como:

    Janela
    Sprite
    Animacao
    Teclado
    Action
    Colisao
    Imagem

o projeto permite estudar como uma aplicação de jogos pode ser dividida em diferentes responsabilidades.

---

# 📌 Resumo da arquitetura

    ┌─────────────────────────────────────┐
    │             AMETHYST2D              │
    └──────────────────┬──────────────────┘
                       │
          ┌────────────┼────────────┐
          │            │            │
          ▼            ▼            ▼
      Janela       Teclado       Cenario
          │            │            │
          │            │       ┌────┴────┐
          │            │       │         │
          │            │    Imagem    Colisao
          │            │       │
          │            │       ▼
          │            │    Animacao
          │            │       │
          │            │       ▼
          │            │     Sprite
          │            │
          └────────────┴──────────────┐
                                      │
                                      ▼
                                  MyGame
                                      │
                         ┌────────────┼────────────┐
                         │            │            │
                         ▼            ▼            ▼
                     Jogador      Inimigos      Moedas
                         │            │            │
                         └────────────┴────────────┘
                                      │
                                      ▼
                                  Colisões
                                      │
                                      ▼
                                  Pontuação

---

# 👤 Autor

**Ryan Alvim**

Desenvolvedor de software com experiência em Java e interesse em desenvolvimento de sistemas, automação e construção de bibliotecas.

- GitHub: [RyanAlvim](https://github.com/RyanAlvim)

---

# 📄 Licença

Consulte os arquivos do repositório para verificar as condições de utilização e distribuição do projeto.
