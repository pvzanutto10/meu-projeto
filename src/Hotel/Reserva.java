package Hotel;

import java.time.LocalDate;

public class Reserva {
    private Hospede hospede;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numeroQuartos;
    private String tipoQuarto;

    public Reserva(Hospede hospede, LocalDate checkIn, LocalDate checkOut, int numeroQuartos, String tipoQuarto) {
        this.hospede = hospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numeroQuartos = numeroQuartos;
        this.tipoQuarto = tipoQuarto;
    }

    
    public Hospede getHospede() { return hospede; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public int getNumeroQuartos() { return numeroQuartos; }
    public String getTipoQuarto() { return tipoQuarto; }
}
