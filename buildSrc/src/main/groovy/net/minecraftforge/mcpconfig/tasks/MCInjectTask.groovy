package net.minecraftforge.mcpconfig.tasks

import org.gradle.api.tasks.*

//Deprecated.. Only here until we migrate all the old versions to not use MCInject
public class MCInjectTask extends ToolJarExec {
    @InputFile File map
    @InputFile File exceptor
    @InputFile File input
    @OutputFile File log
    @OutputFile File dest
    
    @Override
    protected void preExec() {
        setArgs(Utils.fillVariables(args, [
            'map': map,
            'exceptor': exceptor,
            'log': log,
            'input': input,
            'output': dest
        ]))
    }
}