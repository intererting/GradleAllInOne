package com.yly.test

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginWithParams implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create("formater", FormaterExtension)

        project.task("formatDateTime") << {
            println new Date().format(project.formater.dateTimeFormat)
        }
    }
}

class FormaterExtension {
    String dateTimeFormat = "yyyy-MM-dd"
}