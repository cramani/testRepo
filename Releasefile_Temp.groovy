xlr {
    template('variables are resolved during import') {
        description('${release.owner} (release.owner) is resolved during import using task type "externalScript"')
        variables {
            stringVariable('releaseOwner') {
                required false
                showOnReleaseStart false
            }
        }
        folder('Samples & Tutorials')
        phases {
            phase('New Phase') {
                tasks {
                    groovyScript {
                        script('''
releaseVariables["releaseOwner"] = release.owner
'''
                        )
                        owner('${release.owner}')
                    }
                    groovyScript {
                        script('''
println "hello world"
'''
                        )
                        owner('${releaseOwner}')
                    }
                }
            }
        }
    }
}