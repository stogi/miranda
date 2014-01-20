import org.ccil.cowan.tagsoup.Parser

beans = {

    parser(Parser)

    slurper(XmlSlurper, ref('parser'))

}
