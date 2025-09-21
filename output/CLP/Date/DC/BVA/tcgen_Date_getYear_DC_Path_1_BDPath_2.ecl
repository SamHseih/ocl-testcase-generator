:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_1_BDPath_2(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_922511709),
delay_mod(Self_year,4, Var_678433396),
delay_mod(Self_year,400, Var_331994761),
((Var_331994761 #= 0) ; ((Var_678433396 #= 0) , (Var_922511709 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_928294079),
delay_mod(Self_year,4, Var_1647809929),
delay_mod(Self_year,100, Var_1258084361),
delay_mod(Self_year,4, Var_391914049),
delay_mod(Self_year,400, Var_96406857),
((Var_96406857 #\= 0) , (((Var_391914049 #\= 0) , (Var_1258084361 #\= 0)) ; ((Var_1647809929 #= 0) , (Var_928294079 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_758348212),
delay_mod(Self_year,4, Var_817978763),
delay_mod(Self_year,400, Var_1578009262),
((Var_1578009262 #= 0) ; ((Var_817978763 #= 0) , (Var_758348212 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1735507635),
delay_mod(Self_year,4, Var_1362728240),
delay_mod(Self_year,100, Var_1798219673),
delay_mod(Self_year,4, Var_1092572064),
delay_mod(Self_year,400, Var_728885526),
((Var_728885526 #\= 0) , (((Var_1092572064 #\= 0) , (Var_1798219673 #\= 0)) ; ((Var_1362728240 #= 0) , (Var_1735507635 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_869601985),
delay_mod(Self_year,4, Var_1365008457),
delay_mod(Self_year,400, Var_1671179293),
((Var_1671179293 #= 0) ; ((Var_1365008457 #= 0) , (Var_869601985 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1609124502),
delay_mod(Self_year,4, Var_1144068272),
delay_mod(Self_year,100, Var_1985836631),
delay_mod(Self_year,4, Var_1948471365),
delay_mod(Self_year,400, Var_1636506029),
((Var_1636506029 #\= 0) , (((Var_1948471365 #\= 0) , (Var_1985836631 #\= 0)) ; ((Var_1144068272 #= 0) , (Var_1609124502 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1497845528),
delay_mod(Self_year,4, Var_1710989308),
delay_mod(Self_year,400, Var_1047087935),
((Var_1047087935 #= 0) ; ((Var_1710989308 #= 0) , (Var_1497845528 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_464887938),
delay_mod(Self_year,4, Var_2020152163),
delay_mod(Self_year,100, Var_1104443373),
delay_mod(Self_year,4, Var_898694235),
delay_mod(Self_year,400, Var_60292059),
((Var_60292059 #\= 0) , (((Var_898694235 #\= 0) , (Var_1104443373 #\= 0)) ; ((Var_2020152163 #= 0) , (Var_464887938 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1984975621),
delay_mod(Self_year,4, Var_348984985),
delay_mod(Self_year,400, Var_2005435445),
((Var_2005435445 #= 0) ; ((Var_348984985 #= 0) , (Var_1984975621 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1939990953),
delay_mod(Self_year,4, Var_119358627),
delay_mod(Self_year,100, Var_2073621255),
delay_mod(Self_year,4, Var_1208121709),
delay_mod(Self_year,400, Var_873610597),
((Var_873610597 #\= 0) , (((Var_1208121709 #\= 0) , (Var_2073621255 #\= 0)) ; ((Var_119358627 #= 0) , (Var_1939990953 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
