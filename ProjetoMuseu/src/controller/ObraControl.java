package controller;

import java.util.ArrayList;

import entity.Obra;

public class ObraControl {

	public void salvar(Obra obra){
		System.out.println("Opera��o create");
	}
	
	public void alterar(Obra obra){
		System.out.println("Opera��o update");
	}
	
	public void excluir(Obra obra){
		System.out.println("Opera��o delete");
	}
	
	public Obra pesquisar(Obra obra){
		return new Obra();
	}
	
	public ArrayList<Obra> listar(){
		return new ArrayList<Obra>();
	}
}
