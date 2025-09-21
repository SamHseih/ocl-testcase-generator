:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1664439369),
delay_mod(Self_year,4, Var_154482552),
delay_mod(Self_year,400, Var_1781071780),
((Var_1781071780 #= 0) ; ((Var_154482552 #= 0) , (Var_1664439369 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1219402581),
delay_mod(Self_year,4, Var_24119573),
delay_mod(Self_year,100, Var_568221876),
delay_mod(Self_year,4, Var_203849460),
delay_mod(Self_year,400, Var_820914198),
((Var_820914198 #\= 0) , (((Var_203849460 #\= 0) , (Var_568221876 #\= 0)) ; ((Var_24119573 #= 0) , (Var_1219402581 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_178049969),
delay_mod(Self_year,4, Var_333683827),
delay_mod(Self_year,400, Var_1691185247),
((Var_1691185247 #= 0) ; ((Var_333683827 #= 0) , (Var_178049969 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_153245266),
delay_mod(Self_year,4, Var_1699679644),
delay_mod(Self_year,100, Var_1782580546),
delay_mod(Self_year,4, Var_1702940637),
delay_mod(Self_year,400, Var_2114684409),
((Var_2114684409 #\= 0) , (((Var_1702940637 #\= 0) , (Var_1782580546 #\= 0)) ; ((Var_1699679644 #= 0) , (Var_153245266 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_235237152),
delay_mod(Self_year,4, Var_1259014228),
delay_mod(Self_year,400, Var_431687661),
((Var_431687661 #= 0) ; ((Var_1259014228 #= 0) , (Var_235237152 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_283383329),
delay_mod(Self_year,4, Var_893192050),
delay_mod(Self_year,100, Var_644345897),
delay_mod(Self_year,4, Var_1738674023),
delay_mod(Self_year,400, Var_1472682156),
((Var_1472682156 #\= 0) , (((Var_1738674023 #\= 0) , (Var_644345897 #\= 0)) ; ((Var_893192050 #= 0) , (Var_283383329 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_776700275),
delay_mod(Self_year,4, Var_118394766),
delay_mod(Self_year,400, Var_386163331),
((Var_386163331 #= 0) ; ((Var_118394766 #= 0) , (Var_776700275 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1540374340),
delay_mod(Self_year,4, Var_694316372),
delay_mod(Self_year,100, Var_1516500233),
delay_mod(Self_year,4, Var_1850180796),
delay_mod(Self_year,400, Var_884452399),
((Var_884452399 #\= 0) , (((Var_1850180796 #\= 0) , (Var_1516500233 #\= 0)) ; ((Var_694316372 #= 0) , (Var_1540374340 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_215219944),
delay_mod(Self_year,4, Var_1043208434),
delay_mod(Self_year,400, Var_1192171522),
((Var_1192171522 #= 0) ; ((Var_1043208434 #= 0) , (Var_215219944 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1661081225),
delay_mod(Self_year,4, Var_1882554559),
delay_mod(Self_year,100, Var_1049817027),
delay_mod(Self_year,4, Var_23211803),
delay_mod(Self_year,400, Var_1923598304),
((Var_1923598304 #\= 0) , (((Var_23211803 #\= 0) , (Var_1049817027 #\= 0)) ; ((Var_1882554559 #= 0) , (Var_1661081225 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
