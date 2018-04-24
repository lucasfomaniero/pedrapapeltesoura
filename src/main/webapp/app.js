var app = angular.module("PPT", []);
app.controller("PPTcontroller", function($scope, $http){

    $scope.qtdVitoriasSeguidas = 0;
    $scope.qtdVitoriasTotal = 0;
    $scope.jogador1_nome;
    $scope.jogador1_escolha;
    $scope.jogador2_nome;
    $scope.jogador2_escolha;
    $scope.vencedor;
    $scope.perdedor;

    //Inicialização das imagens
    $scope.imgJogada = "../../../images/pedra.png";
    $scope.imgComputador = "../../../images/pedra.png";

    //Propriedades de visibilidade das divs
    $scope.jogoEstaAtivo = false;
    $scope.mostrarBotaoNovoJogo = false;
    $scope.escolhendoJogada = false;

    //Mostra a div para a escolha das jogadas
    $scope.mostrarJogadas = function () {
        $scope.escolhendoJogada = true;
        document.getElementById("proximo").className = "btn btn-primary";
    };

    //Mudar opacidade ao selecionar uma jogada
    $scope.escolherJogada = function(escolha){
        // Acho que dá pra colocar num for
        if(escolha === "Pedra"){
            document.getElementById("Pedra").style.opacity = 1.0;
            document.getElementById("Papel").style.opacity = 0.8;
            document.getElementById("Tesoura").style.opacity = 0.3;
            document.getElementById("Lagarto").style.opacity = 0.3;
            document.getElementById("Spock").style.opacity = 0.8;
        } else if (escolha === "Papel"){
            document.getElementById("Papel").style.opacity = 1.0;
            document.getElementById("Tesoura").style.opacity = 0.8;
            document.getElementById("Lagarto").style.opacity = 0.8;
            document.getElementById("Pedra").style.opacity = 0.3;
            document.getElementById("Spock").style.opacity = 0.3;
        } else if(escolha === "Tesoura"){
            document.getElementById("Pedra").style.opacity = 0.8;
            document.getElementById("Papel").style.opacity = 0.3;
            document.getElementById("Tesoura").style.opacity = 1.0;
            document.getElementById("Lagarto").style.opacity = 0.3;
            document.getElementById("Spock").style.opacity = 0.8;
        } else if (escolha === "Lagarto"){
            document.getElementById("Pedra").style.opacity = 0.8;
            document.getElementById("Papel").style.opacity = 0.3;
            document.getElementById("Tesoura").style.opacity = 0.8;
            document.getElementById("Lagarto").style.opacity = 1.0;
            document.getElementById("Spock").style.opacity = 0.3;
        } else if(escolha === "Spock"){
            document.getElementById("Pedra").style.opacity = 0.3;
            document.getElementById("Papel").style.opacity = 0.8;
            document.getElementById("Tesoura").style.opacity = 0.3;
            document.getElementById("Lagarto").style.opacity = 0.8;
            document.getElementById("Spock").style.opacity = 1.0;
        }
        $scope.mostrarBotaoNovoJogo = true;
        $scope.jogador1_escolha = escolha.toLowerCase();
    };

    //Atualiza a tela ao pressionar o botão Voltar
    $scope.voltar = function(){
        $scope.jogoEstaAtivo = false;
        $scope.escolhendoJogada = true;
        $scope.mostrarBotaoNovoJogo = true;
    };

    //Atualiza a tela para um novo jogo
    $scope.novoJogo = function(){
        $scope.jogoEstaAtivo = true;
        $scope.mostrarBotaoNovoJogo = false;
        $scope.enviarJogada();
    };
    //Envia método POST para o servidor com o nome do Jogador e a Jogada
    $scope.enviarJogada =  function(){

        $http.post("http://localhost:8070/jogos/" + $scope.jogador1_nome + "/" + $scope.jogador1_escolha )
            .then(function(dados){
                $scope.jogador2_nome = dados.data.jogador2_nome;
                $scope.jogador2_escolha = dados.data.jogador2_escolha.toLowerCase();
                $scope.vencedor = dados.data.vencedor;
                $scope.perdedor = dados.data.perdedor;
                $scope.imgJogada = $scope.getImagem($scope.jogador1_escolha);
                $scope.imgComputador = $scope.getImagem($scope.jogador2_escolha.toLowerCase());
                atualizarVitorias();
            }, function(erro){
                console.log("deu ruim")
            });
        console.log("Acabou!")
    };

    //Retorna o caminho da imagem das jogadas
    $scope.getImagem = function(nome){
         return "../../../images/" + nome.toLowerCase() + ".png";
    };
    //Atualiza a quantidade de vitórias consecutivas e no total (envia método GET para o servidor)
    atualizarVitorias = function(){
        if($scope.jogador1_nome === $scope.vencedor){
            $scope.qtdVitoriasSeguidas++;
        } else{
            $scope.qtdVitoriasSeguidas = 0;
        }

        $http.get("http://localhost:8070/jogos/" + $scope.jogador1_nome + "?visao=vitorias")
            .then(function(dados){
                $scope.qtdVitoriasTotal = dados.data;
            }, function(erro){
                console.log("deu ruim")
            });
    }







});