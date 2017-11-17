val pf1: PartialFunction[Any, String] = { case s:String => "YES" }
val pf2: PartialFunction[Any, String] = { case d:Double => "YES" }

val pf = pf1 orElse fp2

def tryPF(x: Any, f: PartialFunction[Any, String]): string =
	try { f(x).toString } catch { case _: MatchError => "ERROR!" }

def d(x: Any, f: PartialFunction[Any, String]) =
	f.isDefinedAt(x).toString

List("str", 3.14, 10) forearch { x =>
	printf("%-5s | %-5s | %-6s | %-5s | %-6 | %-5s | %-6s\n", x.toString,
		d(x, pf1)	)
}