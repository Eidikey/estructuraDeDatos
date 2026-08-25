import csv

def obtener_columna_mes(mes_texto):
    mes_texto = mes_texto.upper().strip()
    match mes_texto:
        case "ENERO" | "1": return 3
        case "FEBRERO" | "2": return 4
        case "MARZO" | "3": return 5
        case "ABRIL" | "4": return 6
        case "MAYO" | "5": return 7
        case "JUNIO" | "6": return 8
        case _:
            print("Mes no valido o fuera de rango. Usando enero por defecto.")
            return 3 

print("Cálculo de visualizaciones de YouTube")
mes1 = input("Ingresa el primer mes: ")
mes2 = input("Ingresa el segundo mes: ")
col1 = obtener_columna_mes(mes1)
col2 = obtener_columna_mes(mes2)

dif_seguidores_tw = 0
dif_vistas_yt = 0

promedio_crecimiento_fb = 0
promedio_crecimiento_tw = 0

promedio_megusta_fb = 0
promedio_megusta_tw = 0
promedio_megusta_yt = 0

with open('datos_redes_sociales.csv', mode='r', encoding='utf-8') as archivo:
    lector = csv.reader(archivo, delimiter=',')
    next(lector) 

    for fila in lector:
        red = fila[0].strip()
        concepto = fila[1].strip()

        if red == "TWITTER" and concepto == "SEGUIDORES (FOLLOWERS)":
            enero = int(fila[3])
            junio = int(fila[8])
            dif_seguidores_tw = junio - enero

        if red == "YOUTUBE" and concepto == "VISUALIZACIONES":
            vistas1 = int(fila[col1])
            vistas2 = int(fila[col2])
            dif_vistas_yt = vistas2 - vistas1

        if red == "FACEBOOK" and concepto == "CRECIMIENTO (seguidores)":
            suma = int(fila[3]) + int(fila[4]) + int(fila[5]) + int(fila[6]) + int(fila[7]) + int(fila[8])
            promedio_crecimiento_fb = suma / 6

        if red == "TWITTER" and concepto == "CRECIMIENTO DE FOLLOWERS":
            suma = int(fila[3]) + int(fila[4]) + int(fila[5]) + int(fila[6]) + int(fila[7]) + int(fila[8])
            promedio_crecimiento_tw = suma / 6

        if red == "FACEBOOK" and concepto == "ME GUSTA EN PUBLICACIONES":
            suma = int(fila[3]) + int(fila[4]) + int(fila[5]) + int(fila[6]) + int(fila[7]) + int(fila[8])
            promedio_megusta_fb = suma / 6

        if red == "TWITTER" and concepto == "ME GUSTA":
            suma = int(fila[3]) + int(fila[4]) + int(fila[5]) + int(fila[6]) + int(fila[7]) + int(fila[8])
            promedio_megusta_tw = suma / 6

        if red == "YOUTUBE" and concepto == "ME GUSTA":
            suma = int(fila[3]) + int(fila[4]) + int(fila[5]) + int(fila[6]) + int(fila[7]) + int(fila[8])
            promedio_megusta_yt = suma / 6

print("\nRESULTADOS")
print(f"Diferencia de seguidores en Twitter (Junio respecto a Enero): {dif_seguidores_tw}")
print(f"Diferencia de vistas en YouTube ({mes2.upper()} respecto a {mes1.upper()}): {dif_vistas_yt}")
print(f"Promedio de crecimiento de Facebook (Ene-Jun): {promedio_crecimiento_fb:.2f}")
print(f"Promedio de crecimiento de Twitter (Ene-Jun): {promedio_crecimiento_tw:.2f}")
print(f"Promedio de 'Me gusta' en Facebook (Ene-Jun): {promedio_megusta_fb:.2f}")
print(f"Promedio de 'Me gusta' en Twitter (Ene-Jun): {promedio_megusta_tw:.2f}")
print(f"Promedio de 'Me gusta' en YouTube (Ene-Jun): {promedio_megusta_yt:.2f}")
