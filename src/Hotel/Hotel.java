package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quartos> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(Quartos quarto) {
        quartos.add(quarto);
    }

    public void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
        for (Quartos quarto : quartos) {
            if (quarto.getTipo().equals(reserva.getTipoQuarto()) && quarto.isDisponivel() && reserva.getNumeroQuartos() > 0) {
                quarto.setDisponivel(false);
                break;
            }
        }
    }

    public void checkIn(Reserva reserva) {
        for (Quartos quarto : quartos) {
            if (quarto.getTipo().equals(reserva.getTipoQuarto()) && !quarto.isDisponivel()) {
                quarto.setDisponivel(false); 
            }
        }
        System.out.println("Check-in realizado para: " + reserva.getHospede().getNome());
    }

    public void checkOut(Reserva reserva) {
        for (Quartos quarto : quartos) {
            if (quarto.getTipo().equals(reserva.getTipoQuarto()) && !quarto.isDisponivel()) {
                quarto.setDisponivel(true); 
            }
        }
        System.out.println("Check-out realizado para: " + reserva.getHospede().getNome());
    }

    public List<Reserva> getReservas() {
        return reservas; 
    }

    public void relatorioOcupacao() {
        int quartosOcupados = 0;
        for (Quartos quarto : quartos) {
            if (!quarto.isDisponivel()) {
                quartosOcupados++;
            }
        }
        System.out.println("Número de quartos ocupados: " + quartosOcupados);
    }

    public void historicoReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Hóspede: " + reserva.getHospede().getNome() +
                               ", Check-in: " + reserva.getCheckIn() +
                               ", Check-out: " + reserva.getCheckOut() +
                               ", Quartos reservados: " + reserva.getNumeroQuartos() +
                               ", Tipo de quarto: " + reserva.getTipoQuarto());
        }
    }
}
