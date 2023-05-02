# -*- coding: utf-8 -*-
import random
import pyodbc

def main(args):
        """ generated source for method main """
        Read()

def Read():
    try:
        Sumn=[]
        rand=random.randint(0,100)
        conn = pyodbc.connect('DRIVER={}'.format('C:/Users/enoch/Documents/FarmJob/Soil Data/soildb_US_2003.mdb'))
        cur = conn.cursor()
        cyl = cur.execute('select * from cocropyld')
        sor = conn.cursor()
        rst = sor.execute('select * from component')
        exe=3
        Yield=CrpYld[101]
        cArea=Area[101]
        for h in range(exe):
            Sumn[h] = rand.nextInt(101)
            h += 1
        # getting data from table
        while (cyl.next()) and (rst.next()):
            for i in range(101):
                Yield[i] = CrpYld(cyl.getString("cropname"), rst.getString("compname"), cyl.getFloat("nonirryield_r"), cyl.getFloat("cokey"), cyl.getString("yldunits"))
                i += 1
        
        while (rst.next()):
            for j in range(101):
                cArea[j] = Area(rst.getString("compname"), rst.getString("taxmoistscl"), rst.getString("taxtempregime"), rst.getFloat("cokey"))
                j += 1
       
        print("3 Random Crop Harvest Facts in Bradley County\n");
        for o in range(exe):
            print (o + 1 + ". ");
            Yield[Sumn[o]].display()
            o += 1
    except Exception as e:
        e.printStackTrace()

class CrpYld(object):
    """ generated source for class CrpYld """
    cName = str()
   # iYield = Double()
    loc = str()
    units = str()

    def __init__(self, cName, loc, iYield, key, units):
        """ generated source for method __init__ """
        self.cName = cName
        self.loc = loc
        self.iYield = iYield
        self.key = key
        self.units = units

    def display(self):
        """ generated source for method display """
        print (self.cName + " cultivated on irrigated land in " + self.loc + " produces about " + self.iYield + " " + self.units + " per acre per year.\n")

class Area(object):
    """ generated source for class Area """
    pName = str()
    moist = str()
    temp = str()

    def __init__(self, pName, moist, temp, key):
        """ generated source for method __init__ """
        self.pName = pName
        self.moist = moist
        self.temp = temp
        self.key = key

    def display(self):
        """ generated source for method display """
        print(self.pName + " has a soil moisture regime of " + self.moist + " and a soil temperature regime of " + self.temp)