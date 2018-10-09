package cn.dlj1.simple;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * java8 新的js引擎
 */
public class JS {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("nashorn");

        System.out.println(engine.eval("var a=1;a++;"));

    }
}
