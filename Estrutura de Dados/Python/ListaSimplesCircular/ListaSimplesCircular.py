from Node import Node

class ListaSimplesCircular:
    primeiro = None
    ultimo = None

    def inserir(self, dado):
        novo = Node(dado)

        if self.primeiro is None:
            self.primeiro = novo
            self.ultimo = novo
        else:
            novo.proximo = self.primeiro
            self.primeiro = novo
            self.ultimo.proximo = self.primeiro

    def inserir_em_ordem(self, dado):
        novo = Node(dado)

        if self.primeiro is None:
            self.inserir(dado)
        else:
            auxiliar = self.primeiro
            anterior = None

            while auxiliar is not None and dado > auxiliar.data:
                anterior = auxiliar
                auxiliar = auxiliar.proximo

            if anterior is None:
                novo.proximo = self.primeiro
                self.primeiro = novo
            else:
                novo.proximo = auxiliar
                anterior.proximo = novo

    def remover(self, dado):
        auxiliar = self.primeiro
        anterior = Node(None)

        while auxiliar is not None and auxiliar.data != dado:
            anterior = auxiliar
            auxiliar = auxiliar.proximo

        anterior.proximo = auxiliar.proximo

    def listar(self):
        auxiliar = self.primeiro

        while auxiliar is not None:
            print("Dado: ", auxiliar.data)
            auxiliar = auxiliar.proximo

    def printar_ultimo(self):
        print("Ultimo: ", self.ultimo.data)
