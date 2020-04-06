package br.com.contmatic.endereco;

import static br.com.contmatic.enums.EnumBairros.SAPOPEMBA;
import static br.com.contmatic.enums.EnumTipoEndereco.CASA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.EasyRandomizer.EasyRandomClass;
import br.com.contmatic.annotation.ValidateAnnotations;

/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

    private static EasyRandomClass randomObject = EasyRandomClass.InstanciaEasyRandomClass();
    
    @Test
    public void deve_verificar_saida_rua() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertTrue(endereco.toString().contains("rua"));
    }
    
    @Test
    public void deve_verificar_saida_bairro() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertTrue(endereco.toString().contains("bairro"));
    }
    
    @Test
    public void deve_verificar_saida_numero() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertTrue(endereco.toString().contains("numero"));
    }
    
    @Test
    public void deve_verificar_saida_regiao() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertTrue(endereco.toString().contains("regiao"));
    }
    
    @Test
    public void deve_verificar_saida_cep() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertTrue(endereco.toString().contains("cep"));
    }
    
    @Test
    public void deve_verificar_saida_tipo() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertTrue(endereco.toString().contains("tipo"));
    }
    /**
     * Deve comparar as classes com hashcode.
     */
    @Test
    public void deve_comparar_as_classes_com_hashcode() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        Endereco comparator = randomObject.EnderecoRandomizer();
        assertNotEquals(endereco.hashCode(), comparator.hashCode());
    }

    /**
     * Deve comparar as classes com equals.
     */
    @Test
    public void deve_comparar_as_classes_com_equals() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        Endereco comparator = randomObject.EnderecoRandomizer();
        assertNotEquals(endereco, comparator);
    }

    /**
     * Deve armazenar rua gerada aleatoriamente com os objetos fake.
     */
    @Test
    public void deve_armazenar_rua_gerada_aleatoriamente_com_os_objetos_fake() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getRua()));
    }

    /**
     * Deve armazenar rua simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_rua_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRua("Rua Padre Estebao");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_rua_nula() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRua(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_rua_numerica() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRua("Ru4 Tu1ti");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_rua_vazia() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRua("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar bairro gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_bairro_gerado_com_objetos_fake() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getBairro()));
    }

    /**
     * Deve armazenar bairro simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_bairro_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setBairro(SAPOPEMBA.getBairro());
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_bairro_nulo() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setBairro(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve setar numero simulando entrada de dados do usuario.
     */
    @Test
    public void deve_setar_numero_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setNumero(666);
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_numero_maior_que_um() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setNumero(0);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar numero gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_aleatoriamente_com_objetos_fake() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getNumero()));
    }

    /**
     * Deve verificar regiao simulando entrada de dados usuario.
     */
    @Test
    public void deve_verificar_regiao_simulando_entrada_de_dados_usuario() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRegiao("Zona Leste");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getRegiao()));
    }

    /**
     * Deve armazenar regiao gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_regiao_gerado_com_objetos_fake() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getRegiao()));
    }

    @Test
    public void deve_verificar_regiao_nulo() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRegiao(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_regiao_vazio() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRegiao("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_regiao_numerico() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setRegiao("Abc3");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar cep gerado automaricamente com objetos fake.
     */
    @Test
    public void deve_armazenar_cep_gerado_automaricamente_com_objetos_fake() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getCep()));
    }

    /**
     * Deve setar cep simulando entrada de dados do usuario.
     */
    @Test
    public void deve_setar_cep_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setCep("03977120");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_nulo() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setCep(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_vazio() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setCep("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_incompleto() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setCep("03977");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_com_letras() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setCep("039sete7120");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar tipo gerado sorteado com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_sorteado_com_objetos_fake() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getTipo()));
    }

    /**
     * Deve armazenar tipo setado diretamente simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_tipo_setado_diretamente_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setTipo(CASA);
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(endereco.getTipo()));
    }

    @Test
    public void deve_verificar_tipo_nulo() {
        Endereco endereco = randomObject.EnderecoRandomizer();
        endereco.setTipo(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(endereco));
    }
}
