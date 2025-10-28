package application.afericoes;

public record AfericaoDTO(long id, String idSensor, String unidade, String valor) {
    
    public AfericaoDTO(Afericao afericao) {
        this(
            afericao.getId(), 
            afericao.getIdSensor(), 
            afericao.getUnidade(), 
            afericao.getValor()
        );
    }
}
