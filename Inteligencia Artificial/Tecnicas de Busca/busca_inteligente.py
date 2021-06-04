# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np

df_cidades_vizinhas = pd.read_csv("DistanciaCidadesVizinhas.txt")
df_distancia_heuristica = pd.read_csv("DistanciaHeuristica.txt")
lista_cidades_vizinhas = df_cidades_vizinhas.values.tolist()
lista_distancia_heuristica = df_distancia_heuristica.values.tolist()

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

class Dijkstra():
    def __init__(self, cidades_vizinhas):
        self.nao_visitada = {cidade: float("inf") for cidade in cidades_vizinhas.keys()}
        self.visitada = {}
        self.cidades_proximas = {}
        self.cidades_vizinhas = cidades_vizinhas
        self.distancia_atual = 0
        self.cidade_atual = 0
        
    # Busca o caminho com menor custo entre duas cidades
    # Parte do pressuposto que o custo inicial para cada cidade é infinito
    # A cidade de inicio possui custo zero
    def busca(self, cidade_inicio, cidade_objetivo):
        self.nao_visitada[cidade_inicio] = self.distancia_atual
        self.cidade_atual = cidade_inicio
        while self.nao_visitada:
            minimo_vertice = min(self.nao_visitada, key=self.nao_visitada.get)
            for vizinho, _ in self.cidades_vizinhas.get(minimo_vertice, {}).items():
                if vizinho not in self.nao_visitada: 
                    continue
                nova_distancia = self.nao_visitada[minimo_vertice] + self.cidades_vizinhas[minimo_vertice].get(vizinho, float("inf"))
                if nova_distancia < self.nao_visitada[vizinho]:
                    self.nao_visitada[vizinho] = nova_distancia
                    self.cidades_proximas[vizinho] = minimo_vertice
            self.visitada[minimo_vertice] = self.nao_visitada[minimo_vertice]
            self.nao_visitada.pop(minimo_vertice)
            if minimo_vertice == cidade_objetivo:
                break
        return self.cidades_proximas, self.visitada
    
    def gerar_caminho(self, proximas, inicio, fim):
        caminho = [fim]
        while True:
            key = proximas[caminho[0]]
            caminho.insert(0, key)
            if key == inicio:
                break
        return caminho


grafo = list_to_graph(lista_cidades_vizinhas)
dji = Dijkstra(grafo)
inicio = "Arad"
fim = "Bucharest"
proximas, visitadas = dji.busca(inicio, fim)
caminhos = dji.gerar_caminho(proximas, inicio, fim)
print("Caminho de %s para %s eh: %s" % (inicio, fim, " -> ".join(caminhos)))
print("Custo De %s Para %s eh: %.2f" % (inicio, fim, visitadas[fim]))

