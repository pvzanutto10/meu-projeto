package Hotel;

import java.util.Scanner;
import java.time.LocalDate;

public class Sistema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Realizar Reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Relatório de Ocupação");
            System.out.println("6. Histórico de Reservas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                	System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo do quarto (solteiro, casal, suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(new Quartos(numero, tipo, preco));
                    break;

                case 2:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Data de Check-in (YYYY-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());
                    System.out.print("Data de Check-out (YYYY-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());
                    System.out.print("Número de quartos: ");
                    int numeroQuartos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de quarto: ");
                    String tipoQuarto = scanner.nextLine();
                    hotel.realizarReserva(new Reserva(new Hospede(nomeHospede), checkIn, checkOut, numeroQuartos, tipoQuarto));
                    break;

                case 3:
                    System.out.print("Nome do hóspede para check-in: ");
                    String nomeHospedeCheckIn = scanner.nextLine();
                    boolean checkInRealizado = false;
                    for (Reserva reserva : hotel.getReservas()) {
                        if (reserva.getHospede().getNome().equals(nomeHospedeCheckIn)) {
                            hotel.checkIn(reserva);
                            checkInRealizado = true;
                            break;
                        }
                    }
                    if (!checkInRealizado) {
                        System.out.println("Reserva não encontrada para o hóspede: " + nomeHospedeCheckIn);
                    }
                    break;

                case 4:
                    System.out.print("Nome do hóspede para check-out: ");
                    String nomeHospedeCheckOut = scanner.nextLine();
                    boolean checkOutRealizado = false;
                    for (Reserva reserva : hotel.getReservas()) {
                        if (reserva.getHospede().getNome().equals(nomeHospedeCheckOut)) {
                            hotel.checkOut(reserva);
                            checkOutRealizado = true;
                            break;
                        }
                    }
                    if (!checkOutRealizado) {
                        System.out.println("Reserva não encontrada para o hóspede: " + nomeHospedeCheckOut);
                    }
                    break;

                case 5:
                    hotel.relatorioOcupacao();
                    break;

                case 6:
                    hotel.historicoReservas();
                    break;

                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
