package org.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class GraalJs {

    private Context jsContext;

    public GraalJs() {
        jsContext = Context.create("js");
    }

    public void printHello() {
        runScript("console.log('Hello from the project')", jsContext);
    }

    public String exchangeData() {
        String script = "console.log('I will welcome you ' + welcomeCount + ' times.');" +
                "for(var i=0; i<welcomeCount; i++){ console.log('Welcome') }";
        Value bindings = jsContext.getBindings("js");
        bindings.putMember("welcomeCount", 3);

        runScript(script, jsContext);

        runScript("var x = 'jsVariable';", jsContext);
        return jsContext.getBindings("js").getMember("x").asString();
    }

    private Value runScript(String script, Context context) {
        return context.eval("js", script);
    }
}
