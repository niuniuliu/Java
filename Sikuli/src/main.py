
from sikuli import *


S0 = Screen(0)
aURL = "www.baidu.com"
imgURLReady = "../img/baidu.png"
imgURLTitle = '../img/baiduTitle.png'

browserLocaltion = r"/Applications/Google Chrome.app"

def gcDefine(gcN="Google Chrome", gcLoc=browserLocaltion):
    global gcProps
    gcProps = {}
    gcProps["name"] = gcN
    gcProps["loc"] = gcLoc
    gcProps["app"] = App(gcN)
    return gcProps["app"]

def gcGetWindow():
    gc = App(gcProps["name"])
    gcWin = None
    for i in range(3):
        if gc.window(0) == None:
            S0.wait(1)
            continue
        for i in range(100):
            gcWin = gc.window(i)
            if gcWin == None:
                break
            if gcWin.w < 200:
                continue
            break
        break
    return gcWin

def gcStart():
    App.open(gcProps["loc"])
    return gcGetWindow()

def gcStop():
    gcName = gcProps["name"]
    if gcGetWindow():
        App.focus(gcName)
        while gcGetWindow():
            App.focus(gcName)
            S0.write("#C.w#w1.")
    App.close(gcName)

def verifyResult(Result):
    if S0.exists(Result):
        return True
    else:
        return False

def gcGoto(url, waitFor=None, waitTime=8):
    gcWin = gcGetWindow()
    if gcWin:
        S0.write("#C.l#w500."); S0.paste(url); S0.write("#N.")
        if waitFor:
            if not gcWin.exists(waitFor, waitTime):
                print "Not found " + waitFor
                return None
            return gcWin.getLastMatch()
    return gcWin


# Steps:

gcApp = gcDefine() 
gcStop() 
gcStart() 
gcGetWindow().highlight(2) 

# Verify Result
found = gcGoto(aURL, imgURLReady) 
if not found:
    print "could not open url:", aURL
    exit(1)
else:
    found.highlight(2)
    if (verifyResult(imgURLTitle) == True):
        foundTitle = gcGoto(aURL, imgURLTitle)
        foundTitle.highlight(2)
        print "Done"
        gcStop()

