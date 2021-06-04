# -*- coding: utf-8 -*-
import pandas as pd

class Cidade:
    def __init__(self, nome):
        self.nome = nome
        self.visitada = False
        self.vizinhas = []
        self.distObjetivo = 0
        
        
    def addCidadeVizinha(self, cidade):
        self.vizinhas.append(cidade)
    
    def addDistanciaObjetivo(self, valor):
        self.distObjetivo = valor
    
    def listToString(self,s):      
        str1 = ""  
        for el in s:  
          str1 += el.cidade.nome + "  " + str(el.distancia)  + "\n"
    
        return str1  

    def show(self):
        print("Nome: ",self.nome,"   /   Distancia para Objetivo: ",self.distObjetivo,
              "\n",
              "Cidades Vizinhas \n"+ self.listToString(self.vizinhas))

class CidadeVizinha:
    def __init__(self, cidade, distancia):
        self.cidade = cidade
        self.distancia = distancia

class BuscaGulosa:
    def __init__(self, objetivo,listCidades):
        self.objetivo = objetivo
        self.achou = False
        self.listCidades = listCidades
        self.cidade_objetivo = self.getCidadeByName(objetivo)
    
    def exibirFronteira(self, fronteira):
        for i  in range(0, len(fronteira)):
            print("\n",fronteira[i].nome, "  -->   ", fronteira[i].distObjetivo)
    
    def getCidadeByName(self,nome):
      for i in self.listCidades:
        if i.nome.strip() == nome.strip():
          return i
                
    def buscar(self, inicio):
        cidade_atual = self.getCidadeByName(inicio)
        print("\n\n Cidade Atual: " ,cidade_atual.nome)
        cidade_atual.visitada = True
        
        if cidade_atual == self.cidade_objetivo:
            self.achou = True
        else: 
            #Lista das cidades vizinhas da cidade atual
            self.fronteira = []
            #Lista da distância das cidades vizinhas a atual
            ldistanciasCidadesVizinhas = []
            # Percorrer as cidades vizinhas adicionando a lista fronteira
            for i in cidade_atual.vizinhas:                
                if i.cidade.visitada == False:
                    i.cidade.visitada = True
                    self.fronteira.append(i.cidade)
                    ldistanciasCidadesVizinhas.append(i.cidade.distObjetivo)

            self.exibirFronteira(self.fronteira)
            #print("custo minimo ",min(ldistanciasCidadesVizinhas))
            #Se existem cidades vizinhas, descobrir a com menor distância para cidade atual
            if len(self.fronteira) > 0:
              cidadeMenorDist = None              
              for i in self.fronteira:
                if i.distObjetivo == min(ldistanciasCidadesVizinhas):                 
                  cidadeMenorDist = i
              # Vai para próxima cidade mais perto da atual             
              BuscaGulosa.buscar(self,cidadeMenorDist.nome.strip())



path1 = "DistanciaHeuristica.txt"
df1 = pd.read_csv(path1)
path2 = "DistanciaCidadesVizinhas.txt"
df2 = pd.read_csv(path2)

listDistanciaHeuristica = df1.values.tolist()
listDistanciaCidadesVizinhas = df2.values.tolist()

listCidades = []

#Percorre o arquivo que contém a lista das cidades, e a distância aproximada de cada uma até o objetivo
for i in df1.values.tolist(): 
   # print(i)
    cidadeA = Cidade(i[0])
    cidadeA.addDistanciaObjetivo(i[1])
    # Percorre o arquivo que contém a lista das cidades vizinhas, e a distância entre elas.
    # Para conectar as cidades vizinhas numa lista de objetos do tipo Cidade
    for j in df2.values.tolist(): 
      #print(j)
      if i[0].strip() == j[0].strip():
        cidadeB = Cidade(j[1]) 
        for z in df1.values.tolist():             
          if z[0].strip() == j[1].strip():
            cidadeB.addDistanciaObjetivo(z[1])       
            
        cidadeviz = CidadeVizinha(cidadeB,j[2])
        cidadeA.addCidadeVizinha(cidadeviz)  
    #cidadeA.show()
    listCidades.append(cidadeA)
  
busca = BuscaGulosa("Bucharest",listCidades)
busca.buscar("Arad")