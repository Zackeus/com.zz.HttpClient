import base64
import simplejson

def test(xx):
    return simplejson.dumps(eval(base64.b64decode(xx)), ensure_ascii=False, encoding="UTF-8")

