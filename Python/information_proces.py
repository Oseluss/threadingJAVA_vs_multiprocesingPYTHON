from multiprocessing import Process, Lock, RLock
from multiprocessing.sharedctypes import Value
import os


def print_func(c,l):
    for i in range(5):
        with l:
            c.value += 1
            print("Process "+str(os.getpid())+ " says tweeeeet!!!" + str(c))


counter = Value('d',0.0,lock=True)
lock = Lock()
procs = [Process(target=print_func, args=(counter, lock)) for i in range(10)]
for p in procs:
    p.start()
for p in procs:
    p.join()

print(counter.value)

print("Han finalizado los hilos")