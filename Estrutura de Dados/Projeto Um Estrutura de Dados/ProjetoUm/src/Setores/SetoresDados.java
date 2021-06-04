/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setores;

import Usuario.FilaUsuarios;
import Usuario.PilhaChamada;
import Usuario.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetoresDados {
    
    private String path = "Setores";
    FileWriter listaSetores;
    File file_setores = new File("Setores/ListaSetores.txt");
    File file_chamada = new File("Setores/ListaChamada.txt");
    
    
    public void criar(String nome) throws IOException
    {
        File novo = new File(path + "/" + nome + ".txt");
        BufferedWriter newFile = new BufferedWriter(new FileWriter(novo));
        
        ListaSetores setores = ler_setores();
        setores.inserir(nome);
        ArrayList<String> lista = setores.toArrayNome();
        
        FileWriter writer = new FileWriter(file_setores);
        BufferedWriter buffWrite = new BufferedWriter(writer);
        
        for(String s: lista)
        {
            buffWrite.append(s);
            buffWrite.newLine();
        }
        
        buffWrite.flush();
        buffWrite.close();
        newFile.close();
        
    }
    
    public void salvar(Usuario usuario, String nome) throws IOException
    {
        FilaUsuarios fila = this.ler_usuarios(nome);
        String dados;
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path + "/" + nome + ".txt"));
        
        fila.enqueue(usuario.getCpf(), usuario.getMatricula(), usuario.getChamada());
        
        ArrayList<ArrayList<String>> lista = fila.toArrayString();
        for(ArrayList<String> s : lista)
        {
            dados = s.get(0) + ";" + s.get(1) + ";" + s.get(2);
            buffWrite.append(dados);
            buffWrite.newLine();
        }

        buffWrite.close();
    }
    
    public void salvar_fila(FilaUsuarios fila, String nome) throws IOException
    {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path + "/" + nome + ".txt"));
        ArrayList<ArrayList<String>> lista = fila.toArrayString();
        String dados;
        
        for(ArrayList<String> s : lista)
        {
            dados = s.get(0) + ";" + s.get(1) + ";" + s.get(2);
            buffWrite.append(dados);
            buffWrite.newLine();
        }
        
        buffWrite.close();
    }
    
    public ListaSetores ler_setores() throws FileNotFoundException, IOException
    {
        String linha = null;
        ListaSetores lista = new ListaSetores();
        FileReader reader = new FileReader(file_setores);
        BufferedReader buffRead = new BufferedReader(reader);
        
        while((linha = buffRead.readLine()) != null)
        {
            lista.inserir(linha);
        }
        
        reader.close();
        buffRead.close();
        return lista;
    }
    
    public void salvar_chamada(Usuario user) throws IOException
    {
        FilaUsuarios fila = ler_usuarios("ListaChamada");
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path + "/ListaChamada.txt"));
        
        PilhaChamada pilha = new PilhaChamada();
        String dados; 
        ArrayList<ArrayList<String>> lista = fila.toArrayString();
        
        for(ArrayList<String> s : lista)
        {
            pilha.push(s.get(0), s.get(1), s.get(2));
        }
        
        pilha.push(user.getMatricula(), user.getCpf(), user.getChamada());
        
        ArrayList<Usuario> pilha_chamada = pilha.toArray();
        
        
        
        for(Usuario s : pilha_chamada)
        {
            dados = s.getMatricula() + ";" + s.getCpf() + ";" + s.getChamada();
            buffWrite.append(dados);
            buffWrite.newLine();
        }
        
        
        buffWrite.close();
    }
    
    public ArrayList<String> ler_chamada() throws FileNotFoundException, IOException
    {
        ArrayList<String> lista = new ArrayList<>();
        String linha = null;
        String[] vet_dados = new String[3];
        FileReader reader = new FileReader(file_chamada);
        BufferedReader buffRead = new BufferedReader(reader);
        
        while((linha = buffRead.readLine()) != null)
        {
            vet_dados = linha.split(";");
            lista.add(vet_dados[2]);
        }
        
        reader.close();
        buffRead.close();
        return lista;
    }
    
    public FilaUsuarios ler_usuarios(String nome) throws FileNotFoundException, IOException
    {
        FilaUsuarios fila = new FilaUsuarios();
        String linha = "";
        String[] vet_aux = new String[3];
        BufferedReader buffRead = new BufferedReader(new FileReader(path + "/" + nome + ".txt"));
        
        while(true)
        {
            linha = buffRead.readLine();
            if(linha != null)
            {
                vet_aux = linha.split(";");             
                fila.enqueue(vet_aux[0], vet_aux[1], vet_aux[2]);
            }
            else
            {
                break;
            }
        }
        
        buffRead.close();
        return fila;
    }
}
