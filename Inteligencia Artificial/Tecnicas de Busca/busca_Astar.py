# -*- coding: utf-8 -*-
"""
Created on Wed Dec  9 12:16:10 2020

@author: lucas
"""

import pandas as pd
from queue import PriorityQueue

df_cidades_vizinhas = pd.read_csv("DistanciaCidadesVizinhas.txt")
df_distancia_heuristica = pd.read_csv("DistanciaHeuristica.txt")
lista_cidades_vizinhas = df_cidades_vizinhas.values.tolist()
lista_heuristica = dict(df_distancia_heuristica.values.tolist())

cidade_inicial = "Arad"
cidade_final = "Bucharest"

def list_to_graph(lista):
    cidades = set([a[0] for a in lista])
    vizinhos = {}
    for cid in cidades:
        vizinhos[cid] = {}
        cidade = []
        distancia = []
        for elemento in lista:
            if elemento[0] == cid:
                cidade.append(elemento[1])
                distancia.append(elemento[2])
        vizinhos[cid] = dict(zip(cidade, distancia))
    return vizinhos

grafo = list_to_graph(lista_cidades_vizinhas)

class Astar:
    def __init__(self, cidades_vizinhas, heuristica):
        self.cidades_vizinhas = cidades_vizinhas
        self.heuristica = heuristica
        self.custo_distancia = dict(zip(cidades_vizinhas.keys(), [0]*len(cidades_vizinhas)))
    
    def h(self, n):
        return self.heuristica[n]
    
    def g(self, n):
        return self.custo_distancia[n]
    
    def f(self, n):
        return self.h(n) + self.g(n)
    
    def busca(self, inicio, fim):
        pq = PriorityQueue()
        pq.put((self.h(inicio), inicio, [inicio]))
        
        while not pq.empty():
            comeco = pq.get()
            cidade = comeco[1]
            if cidade == fim:
                return (comeco[2], comeco[0])
            
            vizinhas = self.cidades_vizinhas[cidade]
            for vizinho, distancia in vizinhas.items():
                self.custo_distancia[vizinho] = self.custo_distancia[cidade] + distancia
                pq.put((self.f(vizinho), vizinho, comeco[2]+[vizinho]))


ast = Astar(grafo, lista_heuristica)
ast.busca(cidade_inicial, cidade_final)