/**
 Aluno: Bruno Yudi Mino Okada

 Sua  tarefa  será  construir  um  código  capaz de  somar,  item  a  item,  todos os  inteiros  entre  1  e 1.000.000.
 Existe, pelo menos uma fórmula matemática que pode ser usada para validar o resultado.
 Contudo, você deverá criar uma fila, armazenar este inteiros nesta fila, depois percorrer  fila somando estes valores.
 A tarefa é para exercitar o uso de algoritmos, não da matemática.
 Atenção: use a mesma plataforma que usou no Trabalho 1 – pilhas.
 Seu  objetivo  será  medir  o  tempo  para  inserção  de  1.000.000  milhão  de  inteiros  em  uma estrutura de dados,
 o tempo para percorrer e somar 1.000.000 de inteiros em uma estrutura de dados,
 e o  tempo para garantir que um determinado  inteiro  já está na  fila (busca).
 Finalmente você deverá medir estes tempos percorrendo a fila em dois sentidos. De cima para baixo e de baixo para cima.
 Seu resultado será a média dos tempos gastos para as operações citadas acima em, no mímino 50 operações de cada tipo.
 As saídas apresentadas devem seguir o seguinte padrão: operação: tempo conforme pode ser visto no exemplo a seguir:
 Preenchimento da Fila: 1.234s
 Programas cuja saída tenham linhas que não sejam relativas as operações realizadas ou
 que não apresentem a formatação correta sofrerão um demérito na nota.
 Para resolver esta tarefa você poderá usar as linguagens Python, Java, C ou C++ de acordo com a  sua  preferência.
 A  tarefa  deverá  ser  entregue  no  ambiente  virtual  de  aprendizagem  conforme
 as instruções constante neste documento.
 Lembre-se: uma estrutura de dados consiste em uma definição de estrutura de memória, e dos métodos,
 ou  funções  para  trabalhar  com  esta  estrutura.
 No  mínimo  teremos que  ter  métodos  para escrever,  ler,  remover  e buscar  valores  na  fila.
 Programas  que  realizem  as  tarefas  necessárias  sem  a definição da estrutura de dados serão zerados.
 */

import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        //Cria uma fila que aceita apenas elementos do tipo inteiro
        Queue<Integer> fila = new LinkedList<Integer>();
        int somatorio = 0;

        //Operações para adicionar todos os números entre 1 e 1.000.000 na fila e calcular o tempo
        long tempoInicioAddFila = System.currentTimeMillis();
        for (int i=1; i<=1000000; i++){
            fila.add(i);
        }
        long tempoFinalAddFila = System.currentTimeMillis();
        long tempoAddFila = tempoFinalAddFila - tempoInicioAddFila;
        System.out.println("Tempo de insercao: " + tempoAddFila + "ms");

        //Operações para verificar se os números de 1 a 150.000 em ordem crescente estão na fila e calcular o tempo
        //apenas 150.000 números pois o enunciado pede apenas 50 operações e
        //quanto maior a amostra muito maior vai ficando o tempo de verificação
        long tempoInicioVerificacaoBaixoCima = System.currentTimeMillis();
        for (int i=1; i<=150000;i++){
            if(fila.contains(i)){
            }
            else{
                System.out.println("O numero " + i + " nao esta dentro da fila!");
            }
        }
        long tempoFinalVerificacaoBaixoCima = System.currentTimeMillis();
        long tempoVerificacaoBaixoCima = tempoFinalVerificacaoBaixoCima - tempoInicioVerificacaoBaixoCima;
        System.out.println("Tempo de verificacao de 150.000 numeros na fila, de baixo para cima: " + tempoVerificacaoBaixoCima + "ms");
        long mediaVerificacaoBaixoCima = tempoVerificacaoBaixoCima/150000;
        System.out.println("Tempo medio de verificacao dos 150.000 numeros, de baixo para cima: "+ mediaVerificacaoBaixoCima + "ms");

        //Operações para verificar se os números de 150.000 a 1 em ordem decrescente estão na fila e calcular o tempo
        //apenas 150.000 números pois o enunciado pede apenas 50 operações e
        //quanto maior a amostra muito maior vai ficando o tempo de verificação
        long tempoInicioVerificacaoCimaBaixo = System.currentTimeMillis();
        for (int i=150000; i>=1; i--){
            if(fila.contains(i)){
            }
            else{
                System.out.println("O numero " + i + " nao esta dentro da fila!");
            }
        }
        long tempoFinalVerificacaoCimaBaixo = System.currentTimeMillis();
        long tempoVerificacaoCimaBaixo = tempoFinalVerificacaoCimaBaixo - tempoInicioVerificacaoCimaBaixo;
        System.out.println("Tempo de verificacao do numero na fila, de cima para baixo: " + tempoVerificacaoCimaBaixo + "ms");
        long mediaVerificacaoCimaBaixo = tempoVerificacaoCimaBaixo/150000;
        System.out.println("Tempo medio de verificacao dos 150.000 numeros, de cima para baixo: " + mediaVerificacaoCimaBaixo + "ms");

        //Operacoes para somar todos os numeros de 1 a 1.000.000, retirá-los da fila e calcular o tempo
        long tempoInicioSomatorio = System.currentTimeMillis();
        for (int i=1; i<= 1000000; i++){
            int numeroParaSomar = fila.poll();
            somatorio += numeroParaSomar;
        }
        System.out.println();
        long tempoFinalSomatorio = System.currentTimeMillis();
        long tempoSomatorio = tempoFinalSomatorio - tempoInicioSomatorio;
        System.out.println("Tempo de somatoria: " + tempoSomatorio + "ms");
        System.out.println("Somatoria dos 1.000.000 elementos: " + somatorio);
    }
}