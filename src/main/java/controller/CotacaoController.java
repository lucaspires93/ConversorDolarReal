package controller;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CotacaoController {

    private final Scanner sc = new Scanner(System.in);

    private double real;
    private double valorDol;
    private double valorReal;


    public void inicializar(){

        char opcao;
        do{
            System.out.println("-- CONVERSOR DOLAR/REAL ---");

            cotacao();

            System.out.println("\n1 - Cotação DOLAR/REAL");
            System.out.println("2 - Cotação REAL/DOLAR");
            System.out.println("0 - Sair");
            System.out.print("\nDigite a opção desejada: ");
            int opcaoInt = sc.nextInt();
            sc.nextLine();

            switch (opcaoInt){
                case 1:
                    System.out.print("\nDigite o valor em Dólar: $ ");
                    valorDol = sc.nextDouble();
                    sc.nextLine();

                    double result = conversaoDolReal();
                    System.out.printf("US$ %.2f equivalem a R$ %.2f%n", valorDol, result);
                break;

                case 2:
                    System.out.print("\nDigite o valor em Real: R$ ");
                    valorReal = sc.nextDouble();
                    sc.nextLine();

                    double resultReal = conversaoRealDol();
                    System.out.printf("R$ %.2f equivalem a US$ %.2f%n", valorReal, resultReal);
                    break;

                case 0:
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }





            System.out.print("\nDeseja repetir a cotação? (s/n) ");
            String entrada = sc.nextLine().trim(); // remove espaços extras

            if (entrada.isEmpty()) {
                // caso o usuário só aperte Enter, define padrão como 'n' (ou pede novamente)
                opcao = 'n';
            } else {
                opcao = entrada.charAt(0);
            }


        }while (opcao!='n');

        sc.close();
    }



    public void cotacao(){
        try {
            // URL da API
            URL url = new URL("https://economia.awesomeapi.com.br/json/last/USD-BRL");

            // Conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Ler resposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }
            reader.close();

            // Converter para JSON
            JSONObject json = new JSONObject(resposta.toString());
            JSONObject usdBrl = json.getJSONObject("USDBRL");

            // Pegar o valor atual (compra)
            String valor = usdBrl.getString("bid");

            real = Double.parseDouble(valor);//Converte para Double

            System.out.println("\nCotação atual do Dólar: R$ " + String.format("%.2f",real));

        } catch (Exception e) {
            System.out.println("Erro ao obter cotação: " + e.getMessage());
        }


    }

    //Metodos para calcular as conversoes
    public double conversaoDolReal(){
        return valorDol * real;
    }

    public double conversaoRealDol(){
        return valorReal / real;
    }
}
