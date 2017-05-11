package projeto.refatorado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date data;
	private String fornecedor;
	private String cnpj;
	private String observacao;
	private List<ItensNota> itensNota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public List<ItensNota> getItensNota() {
		return itensNota;
	}

	public void setItensNota(List<ItensNota> itensNota) {
		this.itensNota = itensNota;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itensNota == null) {
			if (other.itensNota != null)
				return false;
		} else if (!itensNota.equals(other.itensNota))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", data=" + data + ", fornecedor=" + fornecedor + ", cnpj=" + cnpj + ", observacao="
				+ observacao + ", itensNota=" + itensNota + "]";
	}



}
