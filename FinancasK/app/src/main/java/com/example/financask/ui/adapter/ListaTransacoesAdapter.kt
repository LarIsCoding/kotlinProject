package com.example.financask.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.financask.R
import com.example.financask.extension.formataParaBrasileiro
import com.example.financask.extension.limitaEmAte
import com.example.financask.model.TipoTransacao
import com.example.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesAdapter(
    private val transacoes: List<Transacao>,
    private val context: Context): BaseAdapter() {
    private val limiteCaracteres = 22

    override fun getCount(): Int {
        return transacoes.size
    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
        val transacao = transacoes[position]
        configuraCategoria(view, transacao)
        configuraData(view, transacao)
        configuraValor(transacao, view)
        configuraIcone(transacao, view)
        return view
    }

    private fun configuraCategoria(view: View, transacao: Transacao) {
        view.transacao_categoria.text = transacao.categoria.limitaEmAte(limiteCaracteres)
    }

    private fun configuraData(view: View, transacao: Transacao) {
        view.transacao_data.text = transacao.data.formataParaBrasileiro()
    }

    private fun configuraIcone(transacao: Transacao, view: View) {
        val icone = getIcone(transacao)
        view.transacao_icone.setBackgroundResource(icone)
    }

    private fun getIcone(transacao: Transacao) =
        if (transacao.tipo == TipoTransacao.DESPESA) {
            R.drawable.icone_transacao_item_despesa
        } else {
            R.drawable.icone_transacao_item_receita
        }

    private fun configuraValor(transacao: Transacao, view: View) {
        val cor = getCor(transacao)
        view.transacao_valor.setTextColor(cor)
        view.transacao_valor.text = transacao.valor.formataParaBrasileiro()
    }

    private fun getCor(transacao: Transacao) =
        if (transacao.tipo == TipoTransacao.DESPESA) {
            ContextCompat.getColor(context, R.color.despesa)
        } else {
            ContextCompat.getColor(context, R.color.receita)
        }
}