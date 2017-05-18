package projeto.refatorado.model;

import java.io.Serializable;

public class ItensNota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Produto produto;
	private Long notaId;
	private int qtdComprada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNotaId() {
		return notaId;
	}
	public void setNotaId(Long notaId) {
		this.notaId = notaId;
	}
	public int getQtdComprada() {
		return qtdComprada;
	}
	public void setQtdComprada(int qtdComprada) {
		this.qtdComprada = qtdComprada;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItensNota [id=" + id + ", produto=" + produto + ", notaId=" + notaId + ", qtdComprada=" + qtdComprada
				+ "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensNota other = (ItensNota) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notaId == null) {
			if (other.notaId != null)
				return false;
		} else if (!notaId.equals(other.notaId))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtdComprada != other.qtdComprada)
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
