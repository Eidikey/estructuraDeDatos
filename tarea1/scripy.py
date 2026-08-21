import csv

with open ('datos_redes_sociales.csv', mode ='r', encoding='utf-8') as archivo:
    lector = csv.reader(archivo, delimiter=',')

    encabezados = next(lector)
    print(encabezados)

    for fila in lector:
        print(fila)

    datos = list(lector)
    datoEspecifico = datos[2][2]

    print(datoEspecifico)
