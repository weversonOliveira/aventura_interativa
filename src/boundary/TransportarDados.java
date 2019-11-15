package boundary;

import entity.Jogador;

public interface TransportarDados {

    void entityForBoundary(Jogador jogador);

    Jogador boundaryForEntity();
}
