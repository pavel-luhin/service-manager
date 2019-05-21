package com.pluhin.infra.service.manager.service.start

import com.pluhin.infra.service.manager.repository.ComponentRepository
import com.pluhin.infra.service.manager.repository.HistoryRepository
import org.springframework.stereotype.Service
import java.io.InputStream
import java.nio.charset.Charset

@Service
class SimpleStartService(
    private val historyRepository: HistoryRepository,
    private val componentRepository: ComponentRepository
) : StartService {

    override fun start(serviceName: String) {
        runProcess(serviceName)
    }

    @Throws(Exception::class)
    private fun printLines(cmd: String, ins: InputStream) {
        val text = ins.readBytes().toString(Charset.defaultCharset());
        println("$cmd $text")
    }

    @Throws(Exception::class)
    private fun runProcess(command: String) {
        val pro = Runtime.getRuntime().exec(command)
        printLines("$command stdout:", pro.inputStream)
        printLines("$command stderr:", pro.errorStream)
    }
}