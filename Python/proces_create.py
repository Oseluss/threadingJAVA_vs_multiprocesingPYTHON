import os
from multiprocessing import Process


def print_func():
    print("Proces " + str(os.pid())+" says tweeeeet!!!")


procs = []
num_proces = 50
# instantiating process with arguments
for i in range(num_proces):
    # print(name)
    proc = Process(target=print_func)
    procs.append(proc)
    proc.start()
# complete the processes
for proc in procs:
    proc.join()

print("Han finalizado los hilos")