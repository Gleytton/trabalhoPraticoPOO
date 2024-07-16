Trabalho desenvolvido para Disciplina de Programação Orientada a Objetos da professora Flavia.

Segue resumo de problemas e soluções. 

1) Ao começar o desenvolvimento, acredito que tenhamos começado pela ordem errada o trabalho, acredito que o melhor seria ter desenvolvido o layout primeiro e depois ir adicionando as funcionalidades,
tendo em vista que após desenvolver como classe a gente não tem como utilizar o jform para fazer a edição do layout. mas o programa está funcional, só não ficou bonito.

2) Tive problema ao utilizar dados dos arquivos e salva-los nos arquivos .txt, mas obrigado a internet stackoverflow e github copilot, pois me ajudaram a exemplificar e como implementar em meu código utilizando o split para separar a linha
e depois pegar exatamente o dado que vamos utilizar, e recolocando eles na memória de execução para podermos alterar dados e regrava-los no arquivo. após conseguir passificar essa parte os outros métodos do Arquivos.java foram mais faceis de fazer, pois a logica é
basicamente a mesma.

3) Depois que fiz a classe arquivos, tive problema para invoca-la nas subclasses de usuario, pois elas já estavam extendendo usuario. Fiquei quebrando a cabeça para conseguir fazer mas a solução era fácil, só extender ela em usuario, ai as subclasses tambem poderiam 
usar seus métodos.

4) Depois que os métodos da classe arquivo foram criados, o resto foi mais trivial com exceção da parte de guardar as respostas que a pessoa respodeu corretamente, e fazer com que as respondidas corretamente não aparecessem novamente, inclusive não se se vamos conseguir
fazer isso até o dia da apresentação.

5) Tivemos problemas para definir um id único para as perguntas, e acabou que tivemos que fazer mais um método na classe arquivo para poder olhar no arquivo qual o ultimo id e poder utilizar ele para somarmos ao static id de pergunta, assim não tem chance de repetir o id
lembrando que qualquer alteração a palavra é verificada novamente.
