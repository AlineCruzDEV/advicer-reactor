# adviser-reactor
Projeto Final do Módulo Programação Web III - Jornada do Conhecimento Backend Java - F1rst Tecnologia e Inovação e Ada.

### Equipe
Aline Cruz, Daniel Baião, Ícaro Miranda, Juliana Aquino e Leonardo Lopes.

### Principais tecnologias utilizadas
Spring Web Flux, Postgress, OpenFeign, Circuit Breaker.

### Descrição
Trata-se de um aconselhador usando programação reativa. São consumidos conselhos da api [Advice Slip](https://api.adviceslip.com/) e cadastrados no feed, os usuários cadastrados colocam sua lista de interesses, e a cada novo conselho postado é disparado um alerta ao usuário caso seja do seu interesse.

### Justificativa do uso da programação reativa
De acordo com o [Manifesto Reativo](https://www.reactivemanifesto.org/), uma aplicação reativa deve ser resiliente, elástica, responsiva e orientada à mensagem. Para uma aplicação como esta apresentada, onde precisa-se de disaparo de evento e que não seja bloqueante para que aja consumo simultâneo, torna-se valiosíssima essa abordagem. 

Aplicações assíncronas e não bloqueantes evitam bloqueios, gargalos e estresse do usuário, não é mesmo? :grin:
