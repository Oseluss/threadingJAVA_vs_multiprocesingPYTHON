#!/bin/bash

#Programa principal
if [ $# -ne 1 ]; then
 	echo Usage: -nprueba
else #Hay 1 argumento
	echo HOlA > /tmp/resultados.txt
	
	if [ $1 -eq 1 ]; then
		/usr/bin/time -a -o /tmp/resultados.txt -f "\t%E real,\t%U user,\t%S sys" python3 Python/information_proces.py
		cd Java/JavaThreads/src
		/usr/bin/time -a -o /tmp/resultados.txt -f "\t%E real,\t%U user,\t%S sys" java prueba1.ThreadCreator
		cat /tmp/resultados.txt
		exit 0
	fi
	if [ $1 -eq 2 ]; then
		/usr/bin/time -a -o /tmp/resultados.txt -f "\t%E real,\t%U user,\t%S sys" python3 Python/proces_jobs.py
		cd Java/JavaThreads/src
		/usr/bin/time -a -o /tmp/resultados.txt -f "\t%E real,\t%U user,\t%S sys" java prueba2.threadJobs
		cat /tmp/resultados.txt
		exit 0
	fi
	if [ $1 -eq 3 ]; then
		/usr/bin/time -a -o /tmp/resultados.txt -f "\t%E real,\t%U user,\t%S sys" python3 Python/information_proces.py
		cd Java/JavaThreads/src
		/usr/bin/time -a -o /tmp/resultados.txt -f "\t%E real,\t%U user,\t%S sys" java prueba3.informationThread
		cat /tmp/resultados.txt
		exit 0
	fi
	
	echo Introduce como argumento el numero de prueba
fi

exit 0
