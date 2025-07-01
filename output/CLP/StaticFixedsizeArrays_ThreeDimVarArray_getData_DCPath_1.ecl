:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).


solving_Path_1(Self,DimensionSizes,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data],
Dim1#> 0 ,Dim2#> 0 ,Dim3#> 0 ,labeling_Dim([Dim1, Dim2, Dim3]),DimensionSizes = [Dim1, Dim2, Dim3],
dim(Self_data,[Dim1, Dim2, Dim3]),

%CLG Path Constrints,
getDimensionSizes(Self_data, 3, Var_111156771),
getDimensionSizes(Self_data, 2, Var_592617454),
getDimensionSizes(Self_data, 1, Var_1340565491),
(((Var_1340565491 #> 0),
(Var_592617454 #> 0)),
(Var_111156771 #> 0)),
(Result = Self_data),

%Labeling Parts
labeling_Arrays([Self_data]).
