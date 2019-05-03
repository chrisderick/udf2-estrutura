import java.util.ArrayList;
import java.util.Scanner;

public class AdivinhaEstrutura {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer tamanho = s.nextInt();
        Integer[] vetor = new Integer[tamanho];
        ArrayList<Integer> insercoes = new ArrayList<>();
        ArrayList<Integer> remocoes = new ArrayList<>();
        Integer tipoEstrutura = null;
        Integer maiorValor = 0;
        //Garante que os valores removidos existem na estrutura
        boolean existe = true;

        //Permite a entrada de comandos na quantidade informada anteriormente
        for(int i = 0 ; i < vetor.length ; i++) {
            s = new Scanner(System.in);
            String linha = s.nextLine();

            //TODO: Confirmar com a professora se é pra colocar impossível para estas situações
            //Confirma que um valor foi informado
            if(linha.length() > 2) {
                //Armazena o comando (inserção(1)/remoção(2)) a ser executado no valor informado;
                Integer valor = Integer.parseInt(linha.substring(2));
                Integer comando = Integer.parseInt(String.valueOf(linha.charAt(0)));

                //Verifica se o valor está nos conformes estabelecidos pelo enunciado
                if(valor >= 0 && valor <= 100){
                    //Verifica se está sendo realizada uma inserção ou uma remoção na estrutura
                    if(comando == 1){
                        //vetor[i] = valor;
                        if(valor > maiorValor) maiorValor = valor;
                        insercoes.add(valor);
                    } else if (comando == 2) {
                        //Confere se o valor a ser removido já foi inserido antes
                        if (insercoes.contains(valor)){
                            remocoes.add(valor);
                        } else {
                            tipoEstrutura = 0;
                            break;
                        }
                    } else {
                        tipoEstrutura = 0;
                        break;
                    }
                } else {
                    tipoEstrutura = 0;
                    break;
                }
            } else {
                tipoEstrutura = 0;
                break;
            }
        }

        //Comparações
        //Tipo de Estrutura 1: Not Sure
        if (tipoEstrutura != null) {
            if (tamanho == 1) {
                tipoEstrutura = 1;
            } else if (tamanho > 3 && insercoes.size() == remocoes.size()) {
                //Confera se as listas estão invertidas
                boolean estaoInvertidas = true;
                int cont = remocoes.size()-1;
                for (Integer valor : insercoes) {
                    if (!valor.equals(remocoes.get(cont))) {
                        estaoInvertidas = false;
                        break;
                    }
                    cont--;
                }
                //Confera se as listas são iguais
                boolean estaoIguais = true;
                cont = 0;
                for (Integer valor : insercoes) {
                    if (!valor.equals(remocoes.get(cont))) {
                        estaoIguais = false;
                        break;
                    }
                    cont++;
                }
                //Confere se as listas estão ordenadas
                boolean estaOrdenada = true;
                //Estrutura é Pilha ou Fila de Prioridade
                if (estaoInvertidas) {
                    //Confera se as inserções estão em ordem crescente
                    Integer anterior = insercoes.get(0);
                    for (Integer valor : insercoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) < 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    //Confera se as remoções estão em ordem decrescente
                    anterior = remocoes.get(0);
                    for (Integer valor : remocoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) > 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    if (estaOrdenada) {
                        tipoEstrutura = 1;
                    }
                } else if (estaoIguais) {
                    //Confera se as inserções estão em ordem decrescente
                    Integer anterior = insercoes.get(0);
                    for (Integer valor : insercoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) > 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    //Confera se as remoções estão em ordem decrescente
                    anterior = remocoes.get(0);
                    for (Integer valor : remocoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) > 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    if (estaOrdenada) {
                        tipoEstrutura = 1;
                    }
                }
            } else if (remocoes.get(remocoes.size() - 1).equals(maiorValor)) {
                //TODO: Condição G - NOT SURE, tinha um "estaOrdenada" na comparação desse if
            }
        }
    }
}
