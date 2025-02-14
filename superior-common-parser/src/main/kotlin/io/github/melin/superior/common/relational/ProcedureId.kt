package io.github.melin.superior.common.relational

import org.apache.commons.lang3.StringUtils

data class ProcedureId(val catalogName: String?, val schemaName: String?, val procedureName: String) {

    constructor(schemaName: String?, procedureName: String) : this(null, schemaName, procedureName)

    constructor(procedureName: String) : this(null, null, procedureName)

    fun getFullFunctionName(): String {
        if (catalogName != null) {
            return "${catalogName}.${schemaName}.${procedureName}"
        }

        if (schemaName != null) {
            return "${schemaName}.${procedureName}"
        }

        return procedureName
    }

    fun getLowerCatalogName(): String {
        return StringUtils.lowerCase(catalogName)
    }

    fun getLowerSchemaName(): String {
        return StringUtils.lowerCase(schemaName)
    }

    fun getLowerTableName(): String {
        return StringUtils.lowerCase(procedureName)
    }
}
