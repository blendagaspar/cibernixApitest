package com.teste.cibernix;

import com.teste.cibernix.controller.UsuarioController;
import com.teste.cibernix.entities.Usuario;
import com.teste.cibernix.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    Usuario usuario;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    public void usuarioOk() {


        usuarioController.listarTodosUsuarios();

        verify(usuarioRepository.findAll(), times(1)).size();

    }

    @Test
    @DisplayName("Listar paciente por id")
    void listaPacientePorId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuario/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

}








