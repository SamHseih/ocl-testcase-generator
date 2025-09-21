:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_4_BDPath_9(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1301352406),
delay_mod(Self_year,4, Var_640113647),
delay_mod(Self_year,400, Var_124323713),
((Var_124323713 #= 0) ; ((Var_640113647 #= 0) , (Var_1301352406 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_2011997442),
delay_mod(Self_year,4, Var_843512726),
delay_mod(Self_year,100, Var_773989906),
delay_mod(Self_year,4, Var_1631086936),
delay_mod(Self_year,400, Var_1944978632),
((Var_1944978632 #\= 0) , (((Var_1631086936 #\= 0) , (Var_773989906 #\= 0)) ; ((Var_843512726 #= 0) , (Var_2011997442 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1987169128),
delay_mod(Self_year,4, Var_1239183618),
delay_mod(Self_year,400, Var_1804379080),
((Var_1804379080 #= 0) ; ((Var_1239183618 #= 0) , (Var_1987169128 #\= 0))),
(Self_day #= 29),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
