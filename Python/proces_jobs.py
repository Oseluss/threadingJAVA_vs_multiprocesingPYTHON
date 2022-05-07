import os
from multiprocessing import Process


def print_func():
    value = 0
    for i in range(1000):
        value = value + 1000
        value = value/1000
    print("Proces " + str(os.pid())+" says tweeeeet!!!")


procs = []
# instantiating process with arguments
for i in range(50):
    # print(name)
    proc = Process(target=print_func)
    procs.append(proc)
    proc.start()
# complete the processes
for proc in procs:
    proc.join()

print("Han finalizado los procesos")