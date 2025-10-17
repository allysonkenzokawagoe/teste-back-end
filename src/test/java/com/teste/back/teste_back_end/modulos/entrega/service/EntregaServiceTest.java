package com.teste.back.teste_back_end.modulos.entrega.service;

import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import com.teste.back.teste_back_end.modulos.entrega.repository.EntregaRepository;
import com.teste.back.teste_back_end.modulos.pedido.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.teste.back.teste_back_end.modulos.entrega.helper.EntregaHelper.umaEntrega;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedidoDto;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EntregaServiceTest {

    @Mock
    private PedidoService pedidoService;

    @Mock
    private EntregaRepository repository;

    @InjectMocks
    private EntregaService service;

    @Test
    void cadastrarEntrega_deveCadastrarEntrega_quandoSolicitado() {
        var entrega = Entrega.of(umPedidoDto());

        assertThatCode(() -> service.cadastrarEntrega(umPedidoDto())).doesNotThrowAnyException();

        verify(repository).save(entrega);
    }

    @Test
    void listarEntregas_deveBuscarTodos_quandoSolicitado() {
        when(repository.findAll()).thenReturn(List.of(umaEntrega()));

        assertThatCode(() -> service.listarEntregas()).doesNotThrowAnyException();
    }
}
