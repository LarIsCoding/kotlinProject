package com.example.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.financask.R
import com.example.financask.model.TipoTransacao
import com.example.financask.model.Transacao
import com.example.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes = trasacoesExemplo()
        configuraLista(transacoes)
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun trasacoesExemplo() = listOf(
        Transacao(
            valor = BigDecimal(20),
            categoria = "Almoço em família no final de semana",
            tipo = TipoTransacao.DESPESA
        ),
        Transacao(
            valor = BigDecimal(100),
            categoria = "Economia",
            tipo = TipoTransacao.RECEITA
        )
    )
}