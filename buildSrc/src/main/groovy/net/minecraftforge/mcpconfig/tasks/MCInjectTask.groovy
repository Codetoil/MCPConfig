package net.minecraftforge.mcpconfig.tasks

import org.gradle.api.tasks.*

//Deprecated.. Only here until we migrate all the old versions to not use MCInject
public class MCInjectTask extends ToolJarExec {
    // We can have only one set, so all of these need to be optional...
    @Optional @InputFile File map
    @Optional @InputFile File exceptor

    @Optional @InputFile File access
    @Optional @InputFile File constructors
    @Optional @InputFile File exceptions

    @InputFile File input
    @OutputFile File log
    @OutputFile File dest
    
    @Override
    protected void preExec() {
        setArgs(Utils.fillVariables(args, [
            // MCInjector 3.7+
            'access': access,
            'constructors': constructors,
            'exceptions': exceptions,
            // MCInjector 3.6<
            'map': map,
            'exceptor': exceptor,
            // All
            'log': log,
            'input': input,
            'output': dest
        ]))
    }
}